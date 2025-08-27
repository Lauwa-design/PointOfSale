package chromis.dummy.PointOfSale.Product;

import java.math.BigDecimal;


public record ProductResponse (
        String id,

        String productName,

        String barcode, // SKU or Barcode

        String productDescription,

        BigDecimal listPrice, // Standard or Manufacturer's Suggested Retail Price (MSRP)

        Integer stockQuantity ,
        Boolean trackInventory ,
        Boolean active
)
{
    public static ProductResponse fromProductModel(ProductModel productModel){
        return new ProductResponse(
                productModel.getId(),
                productModel.getProductName(),
                productModel.getBarcode(),
                productModel.getProductDescription(),
                productModel.getListPrice(),
                productModel.getStockQuantity(),
                productModel.getTrackInventory(),
                productModel.getActive());
    }
}
