package chromis.dummy.PointOfSale.Price;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data


public class PriceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private BigDecimal sellPrice;
    private String priceListName; // e.g., "Retail", "Wholesale", "Sale Offer"
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
}