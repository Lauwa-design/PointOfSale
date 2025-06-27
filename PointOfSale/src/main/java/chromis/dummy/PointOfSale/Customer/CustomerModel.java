package chromis.dummy.PointOfSale.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter

public class CustomerModel {
    @Id
    String id ;

    @PrePersist
    public void generateId() {
        if (id == null) {
            this.id = UUID.randomUUID().toString();
        }

    }
    private String customerName;
    private String email;
    private Integer phoneNumber;

}
