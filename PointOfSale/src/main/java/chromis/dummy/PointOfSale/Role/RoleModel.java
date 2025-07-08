package chromis.dummy.PointOfSale.Role;


import chromis.dummy.PointOfSale.Enums.Permission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String role;

    @Enumerated(EnumType.STRING)
        private Permission permission;





}

