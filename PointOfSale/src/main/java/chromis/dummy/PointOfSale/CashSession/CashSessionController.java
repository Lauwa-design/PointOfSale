package chromis.dummy.PointOfSale.CashSession;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cash-sessions") // Base URL for this controller
@RequiredArgsConstructor
public class CashSessionController {

    private final CashSessionService cashSessionService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<CashSessionModel> createCashSession(@RequestBody CashSessionRequest request) {
        CashSessionModel response = cashSessionService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<CashSessionModel>> getAllCashSessions() {
        List<CashSessionModel> sessions = cashSessionService.getAll();
        return ResponseEntity.ok(sessions);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<CashSessionModel> getCashSessionById(@PathVariable String id) {
        CashSessionModel response = cashSessionService.getSessionById(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CashSessionModel> updateCashSession(
            @PathVariable String id,
            @RequestBody CashSessionRequest request
    ) {
        CashSessionModel response = cashSessionService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCashSession(@PathVariable String id) {
        cashSessionService.deleteSession(id);
        return ResponseEntity.ok("Cash Session with id " + id + " deleted successfully");
    }
}
