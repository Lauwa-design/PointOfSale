package chromis.dummy.PointOfSale.Role;

import chromis.dummy.PointOfSale.Enums.RoleType;

public record RoleResponse (
         String id,
         String name,
         String role,
         RoleType roleType
)
{
    public static RoleResponse  fromRoleModel(RoleModel roleModel) {
        return new RoleResponse(
                roleModel.getId(),
                roleModel.getName(),
                roleModel.getRole(),
                roleModel.getRoleType());

    }
}