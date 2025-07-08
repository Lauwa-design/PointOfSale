package chromis.dummy.PointOfSale.User;

import chromis.dummy.PointOfSale.Enums.UserStatus;
import jakarta.persistence.*;
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

        @Enumerated(EnumType.STRING)
        private UserStatus userStatus;



    }



