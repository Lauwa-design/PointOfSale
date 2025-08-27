package chromis.dummy.PointOfSale.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductModel create(ProductRequest productRequest);
    List<ProductModel> getAllProducts();
    ProductModel getProductById(String id);
    ProductModel update(String id ,ProductRequest productRequest);
    void delete(String id);
}
