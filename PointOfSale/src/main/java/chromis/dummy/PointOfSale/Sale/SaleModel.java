package chromis.dummy.PointOfSale.Sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class SaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private LocalDateTime saleDate;

    @PrePersist
    public void saleOn() {
        saleDate = LocalDateTime.now();
    }

    private Double totalAmount;
    private Double taxAmount;

}
