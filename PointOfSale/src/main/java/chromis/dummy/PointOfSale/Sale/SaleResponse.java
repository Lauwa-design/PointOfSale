package chromis.dummy.PointOfSale.Sale;


import java.time.LocalDateTime;

public record SaleResponse(
         String id,
         String description,
         LocalDateTime saleDate,
         Double totalAmount,
         Double taxAmount
         ) {
    public static SaleResponse fromCustomerModel(SaleModel saleModel) {
        return new SaleResponse(
                saleModel.getId(),
                saleModel.getDescription(),
                saleModel.getSaleDate(),
                saleModel.getTotalAmount(),
                saleModel.getTaxAmount());

    }
}
