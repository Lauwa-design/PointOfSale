package chromis.dummy.PointOfSale.Supplier;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class SupplierModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean active;



}
