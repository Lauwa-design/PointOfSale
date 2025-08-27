package chromis.dummy.PointOfSale.User;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserModel create(UserRequest userRequest){
        UserModel userModel = new UserModel();
        return userRepository.save(userModel);
    }
    @Override
    public List<UserModel> getAllUsers(){
        return userRepository.findAll();

    }

    @Override
    public UserModel getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found by id:"+ id));

    }

    @Override
    public UserModel update(String id,UserRequest userRequest){
        UserModel existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found by id:"+ id));

        existing.setUserName(userRequest.userName());
        existing.setPassword(userRequest.password());
        existing.setFullName(userRequest.fullName());
        existing.setUserStatus(userRequest.userStatus());

        return userRepository.save(existing);

    }

    @Override
    public void delete(String id){
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);

    }

}
