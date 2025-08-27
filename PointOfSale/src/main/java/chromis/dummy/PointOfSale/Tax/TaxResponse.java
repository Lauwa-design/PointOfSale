package chromis.dummy.PointOfSale.Tax;

import chromis.dummy.PointOfSale.Enums.TicketStatus;


import java.math.BigDecimal;

public record TaxResponse(
        String id,
        String taxName, // e.g., "VAT", "Sales Tax"
        BigDecimal rate,
        Boolean isDefault,
        TicketStatus ticketStatus
)

{

public static TaxResponse fromTaxModel(TaxModel taxModel) {
    return new TaxResponse(
            taxModel.getId(),
            taxModel.getTaxName(),
            taxModel.getRate(),
            taxModel.getIsDefault(),
            taxModel.getTicketStatus()
    );
}
}
