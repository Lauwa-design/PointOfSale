package chromis.dummy.PointOfSale.ManyToMany;

import chromis.dummy.PointOfSale.Role.RoleModel;
import chromis.dummy.PointOfSale.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
        name = "user_role",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_model_id", "role_model_id"})
        })

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private UserModel userModel;

    @ManyToOne
    private RoleModel roleModel;
}
