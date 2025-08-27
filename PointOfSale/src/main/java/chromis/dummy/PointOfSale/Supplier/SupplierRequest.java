package chromis.dummy.PointOfSale.Supplier;

import lombok.Builder;

@Builder
public record SupplierRequest(
         String name,
         String contactPerson,
         String email,
         String phoneNumber,
         String address,
         Boolean active
)
{
   public static SupplierModel toSupplierModel(SupplierRequest supplierRequest){
      return SupplierModel.builder()
              .name(supplierRequest.name())
              .contactPerson(supplierRequest.contactPerson())
              .email(supplierRequest.email())
              .phoneNumber(supplierRequest.phoneNumber())
              .address(supplierRequest.address())
              .active(supplierRequest.active())
              .build();
   }
}
