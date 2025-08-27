package chromis.dummy.PointOfSale.InventoryLog;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryLogService {
    InventoryLogModel create(InventoryLogRequest inventoryLogRequest);
    List<InventoryLogModel> getAll();
    InventoryLogModel getInventoryLog(String id);
    InventoryLogModel update(String id, InventoryLogRequest inventoryLogRequest);
    void deleteInventoryLog(String id);
}
