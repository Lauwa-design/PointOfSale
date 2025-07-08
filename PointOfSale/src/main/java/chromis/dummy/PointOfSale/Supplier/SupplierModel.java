package chromis.dummy.PointOfSale.Supplier;

import jakarta.persistence.*;

@Entity
public class SupplierModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String address;
    private boolean active = true;



}
