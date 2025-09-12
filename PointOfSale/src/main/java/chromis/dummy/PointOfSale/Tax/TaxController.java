package chromis.dummy.PointOfSale.Tax;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxes") // Base URL for this controller
@RequiredArgsConstructor
public class TaxController {

    private final TaxService taxService;


    @PostMapping
    public ResponseEntity<TaxModel> createTax(@RequestBody TaxRequest request) {
        TaxModel response = taxService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TaxModel>> getAllTaxes() {
        List<TaxModel> taxes = taxService.getAllTaxes();
        return ResponseEntity.ok(taxes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaxModel> getTaxById(@PathVariable String id) {
        TaxModel response = taxService.getTaxById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TaxModel> update(
            @PathVariable String id,
            @RequestBody TaxRequest request
    ) {
        TaxModel response = taxService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTax(@PathVariable String id) {
        taxService.deleteTax(id);
        return ResponseEntity.ok("Tax with id " + id + " deleted successfully");
    }
}


