package chromis.dummy.PointOfSale.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceResponse(

         String priceId,

         BigDecimal sellPrice,

         String priceListName, // e.g., "Retail", "Wholesale", "Sale Offer"

         LocalDateTime validFrom,

         LocalDateTime validTo
)
{
    public static PriceResponse  fromCustomerModel(PriceModel priceModel){
        return new PriceResponse(
                priceModel.getPriceId(),
                priceModel.getSellPrice(),
                priceModel.getPriceListName(),
                priceModel.getValidFrom(),
                priceModel.getValidTo());

    }
}
