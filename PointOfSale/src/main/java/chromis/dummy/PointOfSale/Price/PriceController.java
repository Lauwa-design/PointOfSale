package chromis.dummy.PointOfSale.Price;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices") // Base URL for this controller
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<PriceModel> createPrice(@RequestBody PriceRequest request) {
        PriceModel response = priceService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<PriceModel>> getAll() {
        List<PriceModel> prices = priceService.getAll();
        return ResponseEntity.ok(prices);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<PriceModel> getPriceById(@PathVariable String id) {
        PriceModel response = priceService.getPriceById(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PriceModel> update(
            @PathVariable String id,
            @RequestBody PriceRequest request
    ) {
        PriceModel response = priceService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        priceService.delete(id);
        return ResponseEntity.ok("Price with id " + id + " deleted successfully");
    }
}

