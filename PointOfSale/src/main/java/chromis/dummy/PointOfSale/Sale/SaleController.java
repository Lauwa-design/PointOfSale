package chromis.dummy.PointOfSale.Sale;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales") // Base URL for this controller
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;


    @PostMapping
    public ResponseEntity<SaleModel> createSale(@RequestBody SaleRequest request) {
        SaleModel response = saleService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SaleModel>> getAllSales() {
        List<SaleModel> sales = saleService.getAll();
        return ResponseEntity.ok(sales);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SaleModel> getSaleById(@PathVariable String id) {
        SaleModel response = saleService.getById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SaleModel> update(
            @PathVariable String id,
            @RequestBody SaleRequest request
    ) {
        SaleModel response = saleService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable String id) {
        saleService.delete(id);
        return ResponseEntity.ok("Sale with id " + id + " deleted successfully");
    }
}

