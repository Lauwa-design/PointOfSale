package chromis.dummy.PointOfSale.Customer;

import lombok.Builder;

@Builder
public record CustomerRequest(
         String customerName,
         String email,
         Integer phoneNumber
)
{
public static CustomerModel toCustomerModel(CustomerRequest customerRequest){
    return CustomerModel.builder()
            .customerName(customerRequest.customerName())
            .email(customerRequest.email())
            .phoneNumber(customerRequest.phoneNumber())
            .build();
}
}
