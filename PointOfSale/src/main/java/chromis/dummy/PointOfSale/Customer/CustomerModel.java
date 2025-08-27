package chromis.dummy.PointOfSale.Customer;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id ;
    private String customerName;
    private String email;
    private Integer phoneNumber;

}
