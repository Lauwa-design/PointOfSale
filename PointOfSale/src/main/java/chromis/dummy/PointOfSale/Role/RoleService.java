package chromis.dummy.PointOfSale.Role;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    RoleModel create(RoleRequest roleRequest);
    List<RoleModel> getAllRoles();
    RoleModel getRoleById(String id);
    RoleModel update (String id ,RoleRequest roleRequest);
    void delete(String id);
}
