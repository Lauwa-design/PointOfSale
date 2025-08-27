package chromis.dummy.PointOfSale.Sale;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class SaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private LocalDateTime saleDate;

    @PrePersist
    public void saleOn() {
        saleDate = LocalDateTime.now();
    }

    private Double totalAmount;
    private Double taxAmount;

}
