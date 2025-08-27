package chromis.dummy.PointOfSale.InventoryLog;

import chromis.dummy.PointOfSale.Enums.InventoryLogReason;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record InventoryLogRequest (
        String description,
        Integer quantity,
        InventoryLogReason reason)
{
    public static InventoryLogModel toInventoryLogModel(InventoryLogRequest inventoryLogRequest) {
        return InventoryLogModel.builder()
                .description(inventoryLogRequest.description())
                .quantity(inventoryLogRequest.quantity())
                .reason(inventoryLogRequest.reason())
                .build();

    }
}
