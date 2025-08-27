
package chromis.dummy.PointOfSale.Customer;


public record CustomerResponse(
        String id,
        String customerName,
        String email,
        Integer phoneNumber
)
{
    public static CustomerResponse  fromCustomerModel(CustomerModel customerModel){
        return new CustomerResponse(
                customerModel.getId(),
                customerModel.getCustomerName(),
                customerModel.getEmail(),
                customerModel.getPhoneNumber());

    }
}

