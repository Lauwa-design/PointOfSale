package chromis.dummy.PointOfSale.User;

import chromis.dummy.PointOfSale.Enums.UserStatus;


public record UserResponse (
     String id ,
     String userName,
     String password,
     String fullName,
     UserStatus userStatus)
{
    public static UserResponse  fromUserResponse(UserModel userModel){
        return new UserResponse(
                userModel.getId(),
                userModel.getUserName(),
                userModel.getPassword(),
                userModel.getFullName(),
                userModel.getUserStatus()
        );
        
    }

}
