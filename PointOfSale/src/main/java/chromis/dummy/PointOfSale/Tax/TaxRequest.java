package chromis.dummy.PointOfSale.Tax;

import chromis.dummy.PointOfSale.Enums.TicketStatus;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TaxRequest(
         String taxName, // e.g., "VAT", "Sales Tax"
         BigDecimal rate,
         Boolean isDefault,
         TicketStatus ticketStatus
)
{
    private static TaxModel toTaxModel(TaxRequest taxRequest) {
        return TaxModel.builder()
                .taxName(taxRequest.taxName())
                .rate(taxRequest.rate())
                .isDefault(taxRequest.isDefault())
                .ticketStatus(taxRequest.ticketStatus())
                .build();
    }
}
