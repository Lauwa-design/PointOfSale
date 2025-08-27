package chromis.dummy.PointOfSale.Price;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class PriceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String priceId;
    private BigDecimal sellPrice;
    private String priceListName; // e.g., "Retail", "Wholesale", "Sale Offer"
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
}