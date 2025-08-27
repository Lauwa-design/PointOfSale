package chromis.dummy.PointOfSale.InventoryLog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryLogServiceImpl implements InventoryLogService {
    private final InventoryLogRepository inventoryLogRepository;

    @Override
    public InventoryLogModel create(InventoryLogRequest inventoryLogRequest) {
        InventoryLogModel inventoryLogModel = new InventoryLogModel();
        return inventoryLogRepository.save(inventoryLogModel);

    }

    @Override
    public List<InventoryLogModel> getAll() {
        return inventoryLogRepository.findAll();

    }

    @Override
    public InventoryLogModel getInventoryLog(String id) {
        return inventoryLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InventoryLog not found with ID: " + id));

    }

    @Override
    public InventoryLogModel update(String id, InventoryLogRequest inventoryLogRequest) {
        InventoryLogModel existing = inventoryLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InventoryLog not found with ID: " + id));

        // Update fields from request
        existing.setDescription(inventoryLogRequest.description());
        existing.setQuantity(inventoryLogRequest.quantity());
        existing.setReason(inventoryLogRequest.reason());

        return inventoryLogRepository
                .save(existing);
    }

    @Override
    public void deleteInventoryLog(String id) {
        if (!inventoryLogRepository.existsById(id)) {
            throw new RuntimeException("Cash session not found with ID: " + id);
        }
        inventoryLogRepository.deleteById(id);
    }
}


