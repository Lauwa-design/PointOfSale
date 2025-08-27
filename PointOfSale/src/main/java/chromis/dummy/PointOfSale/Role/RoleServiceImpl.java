package chromis.dummy.PointOfSale.Role;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public RoleModel create(RoleRequest roleRequest){
        RoleModel roleModel = new RoleModel();
        return roleRepository.save(roleModel);
    }
    @Override
    public List<RoleModel> getAllRoles(){
        return roleRepository.findAll();

    }

    @Override
    public RoleModel getRoleById(String id){
        return roleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Role not found by id:"+ id));

    }

    @Override
    public RoleModel update(String id,RoleRequest roleRequest){
        RoleModel existing = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found by id:"+ id));

        existing.setName(roleRequest.name());
        existing.setRole(roleRequest.role());
        existing.setRoleType(roleRequest.roleType());


        return roleRepository.save(existing);

    }

    @Override
    public void delete(String id){
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found with ID: " + id);
        }
        roleRepository.deleteById(id);

    }

}
