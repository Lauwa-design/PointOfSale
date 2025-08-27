package chromis.dummy.PointOfSale.Price;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record PriceRequest (
         BigDecimal sellPrice,
         String priceListName, // e.g., "Retail", "Wholesale", "Sale Offer"
         LocalDateTime validFrom,
         LocalDateTime validTo
)
{
    public static PriceModel toPriceModel (PriceRequest priceRequest) {
        return PriceModel.builder()
                .sellPrice(priceRequest.sellPrice())
                .priceListName(priceRequest.priceListName())
                .validFrom(priceRequest.validFrom())
                .validTo(priceRequest.validTo())
                .build();
    }
}
