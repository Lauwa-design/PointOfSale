package chromis.dummy.PointOfSale.Customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers") // Base URL for this controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerRequest request) {
        CustomerModel response = customerService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<CustomerModel>> getAll() {
        List<CustomerModel> customers = customerService.getAll();
        return ResponseEntity.ok(customers);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable String id) {
        CustomerModel response = customerService.getCustomerById(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CustomerModel> update(
            @PathVariable String id,
            @RequestBody CustomerRequest request
    ) {
        CustomerModel response = customerService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer with id " + id + " deleted successfully");
    }
}
