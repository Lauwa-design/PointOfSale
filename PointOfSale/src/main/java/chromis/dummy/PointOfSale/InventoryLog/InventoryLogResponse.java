package chromis.dummy.PointOfSale.InventoryLog;


import chromis.dummy.PointOfSale.Enums.InventoryLogReason;


import java.time.LocalDateTime;

public record InventoryLogResponse(
         String id,
         String description,
         Integer quantity,
         LocalDateTime movementDate,
         InventoryLogReason reason
) {
    public static InventoryLogResponse fromInventoryLogModel(InventoryLogModel inventoryLogModel) {
        return new InventoryLogResponse(
                inventoryLogModel.getId(),
                inventoryLogModel.getDescription(),
                inventoryLogModel.getQuantity(),
                inventoryLogModel.getMovementDate(),
                inventoryLogModel.getReason());

    }
}
