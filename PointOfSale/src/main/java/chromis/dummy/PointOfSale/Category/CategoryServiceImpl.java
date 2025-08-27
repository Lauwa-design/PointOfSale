package chromis.dummy.PointOfSale.Category;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    public final CategoryRepository categoryRepository;

    // CREATE
    @Override
    public CategoryModel create(CategoryRequest categoryRequest) {
        CategoryModel model = CategoryRequest.toCategoryModel(categoryRequest);
        return categoryRepository.save(model);
    }

    // READ ALL
    @Override
    public List<CategoryModel> getAll() {

        return categoryRepository.findAll();
    }

    // READ BY ID
    @Override
    public CategoryModel getCategoryById(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
    }

    // UPDATE
    @Override
    public CategoryModel update(String id, CategoryRequest categoryRequest) {
        CategoryModel existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));

        // Update fields from categoryRequest
        existing.setCategoryName(categoryRequest.categoryName());
        existing.setDescription(categoryRequest.description());

        return categoryRepository
                .save(existing); // @PreUpdate will set endTime
    }

    // DELETE
    @Override
    public void deleteCategory(String id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with ID: " + id);
        }
        categoryRepository.deleteById(id);
    }
}
