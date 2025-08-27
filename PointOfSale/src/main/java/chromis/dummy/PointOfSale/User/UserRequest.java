package chromis.dummy.PointOfSale.User;

import chromis.dummy.PointOfSale.Enums.UserStatus;
import lombok.Builder;

@Builder
public record UserRequest (
          String userName,
          String password,
          String fullName,
          UserStatus userStatus
)
{
  public static UserModel toUserModel(UserRequest userRequest) {
      return UserModel.builder()
              .userName(userRequest.userName)
              .password(userRequest.password)
              .fullName(userRequest.fullName)
              .userStatus(userRequest.userStatus)
              .build();
  }
}
