package chromis.dummy.PointOfSale.User;

import chromis.dummy.PointOfSale.Enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;


    private String userName;
    private String password;
    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;



    }



