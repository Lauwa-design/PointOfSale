package chromis.dummy.PointOfSale.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") // Base URL for this controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductRequest request) {
        ProductModel response = productService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable String id) {
        ProductModel response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> update(
            @PathVariable String id,
            @RequestBody ProductRequest request
    ) {
        ProductModel response = productService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.ok("Product with id " + id + " deleted successfully");
    }
}

