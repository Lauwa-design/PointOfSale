package chromis.dummy.PointOfSale.Supplier;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers") // Base URL for this controller
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;


    @PostMapping
    public ResponseEntity<SupplierModel> createSupplier(@RequestBody SupplierRequest request) {
        SupplierModel response = supplierService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SupplierModel>> getAllSuppliers() {
        List<SupplierModel> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SupplierModel> getSupplierById(@PathVariable String id) {
        SupplierModel response = supplierService.getSupplier(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SupplierModel> update(
            @PathVariable String id,
            @RequestBody SupplierRequest request
    ) {
        SupplierModel response = supplierService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable String id) {
        supplierService.delete(id);
        return ResponseEntity.ok("Supplier with id " + id + " deleted successfully");
    }
}


