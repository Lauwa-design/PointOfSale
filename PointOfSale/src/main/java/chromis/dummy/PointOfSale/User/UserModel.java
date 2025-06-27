package chromis.dummy.PointOfSale.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {
    @Id
    String id ;

    @PrePersist
    public void generateId() {
        if (id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
        private String userName;
        private String password;
        private String fullName;

    }



