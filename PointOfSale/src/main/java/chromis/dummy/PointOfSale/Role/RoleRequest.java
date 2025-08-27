package chromis.dummy.PointOfSale.Role;

import chromis.dummy.PointOfSale.Enums.RoleType;
import lombok.Builder;

@Builder
public record RoleRequest (
         String name,
         String role,
         RoleType roleType
)
{
    public static RoleModel toRoleModel(RoleRequest roleRequest) {
        return RoleModel.builder()
                .name(roleRequest.name())
                .role(roleRequest.role())
                .roleType(roleRequest.roleType()).build();
    }
}
