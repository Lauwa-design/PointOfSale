package chromis.dummy.PointOfSale.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories") // Base URL for this controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryRequest request) {
        CategoryModel response = categoryService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<CategoryModel>> getAll() {
        List<CategoryModel> categories = categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getCategoryById(@PathVariable String id) {
        CategoryModel response = categoryService.getCategoryById(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CategoryModel> updateCategory(
            @PathVariable String id,
            @RequestBody CategoryRequest request
    ) {
        CategoryModel response = categoryService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category with id " + id + " deleted successfully");
    }
}
