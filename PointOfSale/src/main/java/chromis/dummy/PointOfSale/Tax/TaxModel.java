package chromis.dummy.PointOfSale.Tax;


import chromis.dummy.PointOfSale.Enums.TicketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class TaxModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taxName; // e.g., "VAT", "Sales Tax"
    private BigDecimal rate;
    private boolean isDefault = false;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;


}
