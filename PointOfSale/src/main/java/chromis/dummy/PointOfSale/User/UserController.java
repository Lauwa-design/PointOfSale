package chromis.dummy.PointOfSale.User;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // Base URL for this controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserRequest request) {
        UserModel response = userService.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable String id) {
        UserModel response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update(
            @PathVariable String id,
            @RequestBody UserRequest request
    ) {
        UserModel response = userService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok("User with id " + id + " deleted successfully");
    }
}


