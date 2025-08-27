package chromis.dummy.PointOfSale.Tax;


import chromis.dummy.PointOfSale.Enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TaxModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String taxName; // e.g., "VAT", "Sales Tax"
    private BigDecimal rate;
    private Boolean isDefault;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;


}
