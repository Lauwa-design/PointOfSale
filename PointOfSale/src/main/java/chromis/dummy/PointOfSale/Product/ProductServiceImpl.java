package chromis.dummy.PointOfSale.Product;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductModel create(ProductRequest productRequest){
        ProductModel productModel = new ProductModel();
       return productRepository.save(productModel);
    }

    @Override
    public List<ProductModel> getAllProducts(){

        return productRepository.findAll();
    }

    @Override
    public ProductModel getProductById(String id){

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found :" + id));
    }

    @Override
    public ProductModel update(String id ,ProductRequest productRequest){
        ProductModel existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found :" + id));

         existing.setProductName(productRequest.productName());
         existing.setBarcode(productRequest.barcode());
         existing.setProductDescription(productRequest.productDescription());
         existing.setListPrice(productRequest.listPrice());
         existing.setStockQuantity(productRequest.stockQuantity());
         existing.setTrackInventory(true);
         existing.setActive(true);

         return productRepository.save(existing);

    }

    @Override
    public void delete(String id){

        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
    }
}
