package chromis.dummy.PointOfSale.InventoryLog;

import chromis.dummy.PointOfSale.Enums.InventoryLogReason;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class InventoryLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    private Integer quantity;
    private LocalDateTime movementDate;

    @PrePersist
    public void changeDate() {
        movementDate = LocalDateTime.now();

    }
    @Enumerated(EnumType.STRING)
    private InventoryLogReason reason;

}
