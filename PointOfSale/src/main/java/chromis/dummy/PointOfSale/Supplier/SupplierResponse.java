package chromis.dummy.PointOfSale.Supplier;

public record SupplierResponse (
         String id,
         String name,
         String contactPerson,
         String email,
         String phoneNumber,
         String address,
         Boolean active
)
{
    public static SupplierResponse fromSupplierModel(SupplierModel supplierModel) {
        return new SupplierResponse(
                supplierModel.getId(),
                supplierModel.getName(),
                supplierModel.getContactPerson(),
                supplierModel.getEmail(),
                supplierModel.getPhoneNumber(),
                supplierModel.getAddress(),
                supplierModel.getActive()
        );
    }
}
