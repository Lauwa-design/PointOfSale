package chromis.dummy.PointOfSale.InventoryLog;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-logs") // Base URL for this controller
@RequiredArgsConstructor
public class InventoryLogController {

    private final InventoryLogService inventoryLogService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<InventoryLogModel> createInventoryLog(@RequestBody InventoryLogRequest request) {
        InventoryLogModel response = inventoryLogService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<InventoryLogModel>> getAll() {
        List<InventoryLogModel> inventorylogs = inventoryLogService.getAll();
        return ResponseEntity.ok(inventorylogs);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<InventoryLogModel> getInventoryLog(@PathVariable String id) {
        InventoryLogModel response = inventoryLogService.getInventoryLog(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<InventoryLogModel> update(
            @PathVariable String id,
            @RequestBody InventoryLogRequest request
    ) {
        InventoryLogModel response = inventoryLogService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInventoryLog(@PathVariable String id) {
        inventoryLogService.deleteInventoryLog(id);
        return ResponseEntity.ok("InventoryLog with id " + id + " deleted successfully");
    }
}



