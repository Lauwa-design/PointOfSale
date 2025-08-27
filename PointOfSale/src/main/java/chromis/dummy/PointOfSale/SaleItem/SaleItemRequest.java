package chromis.dummy.PointOfSale.SaleItem;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SaleItemRequest(
         String description,
         int quantity,
         BigDecimal price
)
{
    public static SaleItemModel toSaleItemModel(SaleItemRequest saleItemRequest)
    {
        return SaleItemModel.builder()
                .description(saleItemRequest.description())
                .quantity(saleItemRequest.quantity())
                .price(saleItemRequest.price())
                .build();
    }
}
