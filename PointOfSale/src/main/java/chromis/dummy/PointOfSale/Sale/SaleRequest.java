package chromis.dummy.PointOfSale.Sale;


import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SaleRequest (
         String description,
         Double totalAmount,
         Double taxAmount

){
    public static SaleModel toSaleModel(SaleRequest saleRequest) {
        return SaleModel.builder()
                .description(saleRequest.description())
                .totalAmount(saleRequest.totalAmount())
                .taxAmount(saleRequest.taxAmount())
                .build();
    }
}
