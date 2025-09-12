package chromis.dummy.PointOfSale.Payment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments") // Base URL for this controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<PaymentModel> createPayment(@RequestBody PaymentRequest request) {
        PaymentModel response = paymentService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<PaymentModel>> getAll() {
        List<PaymentModel> payments = paymentService.getAll();
        return ResponseEntity.ok(payments);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<PaymentModel> getPaymentById(@PathVariable String id) {
        PaymentModel response = paymentService.getPaymentById(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PaymentModel> updatePayment(
            @PathVariable String id,
            @RequestBody PaymentRequest request
    ) {
        PaymentModel response = paymentService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        paymentService.delete(id);
        return ResponseEntity.ok("Payment with id " + id + " deleted successfully");
    }
}

