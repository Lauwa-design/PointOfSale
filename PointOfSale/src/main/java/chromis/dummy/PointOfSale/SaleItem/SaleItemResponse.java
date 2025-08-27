package chromis.dummy.PointOfSale.SaleItem;

import java.math.BigDecimal;

public record SaleItemResponse(
     String id,
     String description,
     Integer quantity,
     BigDecimal price
)
{
    public static SaleItemResponse  fromSaleItemModel(SaleItemModel saleItemrModel){
        return new SaleItemResponse(
                saleItemrModel.getId(),
                saleItemrModel.getDescription(),
                saleItemrModel.getQuantity(),
                saleItemrModel.getPrice());
    }
}
