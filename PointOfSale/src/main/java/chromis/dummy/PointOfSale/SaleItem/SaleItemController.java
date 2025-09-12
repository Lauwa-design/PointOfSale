
package chromis.dummy.PointOfSale.SaleItem;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale-items") // Base URL for this controller
@RequiredArgsConstructor
public class SaleItemController {

    private final SaleItemService saleItemService;


    @PostMapping
    public ResponseEntity<SaleItemModel> createSaleItem(@RequestBody SaleItemRequest request) {
        SaleItemModel response = saleItemService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SaleItemModel>> getAllSaleItems() {
        List<SaleItemModel> saleitems = saleItemService.getAllSaleItems();
        return ResponseEntity.ok(saleitems);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SaleItemModel> getSaleItemById(@PathVariable String id) {
        SaleItemModel response = saleItemService.getSaleItemById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SaleItemModel> update(
            @PathVariable String id,
            @RequestBody SaleItemRequest request
    ) {
        SaleItemModel response = saleItemService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSaleItem(@PathVariable String id) {
        saleItemService.delete(id);
        return ResponseEntity.ok("SaleItem with id " + id + " deleted successfully");
    }
}

