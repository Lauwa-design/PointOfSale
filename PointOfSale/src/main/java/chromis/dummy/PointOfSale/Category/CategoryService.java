package chromis.dummy.PointOfSale.Category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryModel create(CategoryRequest customerRequest);
    List<CategoryModel> getAll();
    CategoryModel getCategoryById(String id);
    CategoryModel update(String id, CategoryRequest customerRequest);
    void deleteCategory(String id);
}

