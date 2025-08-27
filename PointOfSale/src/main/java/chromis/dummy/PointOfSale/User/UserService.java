package chromis.dummy.PointOfSale.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserModel create(UserRequest userRequest);
    List<UserModel> getAllUsers();
    UserModel getUserById(String id);
    UserModel update(String id, UserRequest userRequest);
    void delete(String id);
}
