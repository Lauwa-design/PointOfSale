package chromis.dummy.PointOfSale.Role;
import chromis.dummy.PointOfSale.Enums.RoleType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String role;

    @Enumerated(EnumType.STRING)
        private RoleType roleType;





}

