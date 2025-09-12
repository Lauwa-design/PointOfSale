package chromis.dummy.PointOfSale.Role;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles") // Base URL for this controller
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<RoleModel> createCashSession(@RequestBody RoleRequest request) {
        RoleModel response = roleService.create(request);
        return ResponseEntity.ok(response);
    }

    // ✅ READ (Get all)
    @GetMapping
    public ResponseEntity<List<RoleModel>> getAllRoles() {
        List<RoleModel> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    // ✅ READ (Get by ID)
    @GetMapping("/{id}")
    public ResponseEntity<RoleModel> getRoleById(@PathVariable String id) {
        RoleModel response = roleService.getRoleById(id);
        return ResponseEntity.ok(response);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<RoleModel> updateCashSession(
            @PathVariable String id,
            @RequestBody RoleRequest request
    ) {
        RoleModel response = roleService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        roleService.delete(id);
        return ResponseEntity.ok("Role with id " + id + " deleted successfully");
    }
}

