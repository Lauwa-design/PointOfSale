package chromis.dummy.PointOfSale.Product;


import lombok.Builder;

import java.math.BigDecimal;

@Builder

public record ProductRequest (
        String productName,

        String barcode, // SKU or Barcode

        String productDescription,

        BigDecimal listPrice, // Standard or Manufacturer's Suggested Retail Price (MSRP)

        Integer stockQuantity ,
        Boolean trackInventory ,
        Boolean active
)
{
    public static ProductModel toProductModel(ProductRequest productRequest){
        return ProductModel.builder()
                .productName(productRequest.productName())
                .barcode(productRequest.barcode())
                .productDescription(productRequest.productDescription())
                .listPrice(productRequest.listPrice())
                .stockQuantity(productRequest.stockQuantity())
                .trackInventory(true)
                .active(true)
                .build();
    }
}