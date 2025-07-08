package chromis.dummy.PointOfSale.InventoryLog;

import chromis.dummy.PointOfSale.Enums.InventoryLogReason;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data


public class InventoryLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Integer quantity;
    private LocalDateTime movementDate;

    @PrePersist
    public void changeDate() {
        movementDate = LocalDateTime.now();

    }
    @Enumerated(EnumType.STRING)
    private InventoryLogReason reason ;

}
