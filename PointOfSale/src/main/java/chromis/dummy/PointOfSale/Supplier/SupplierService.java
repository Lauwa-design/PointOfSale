package chromis.dummy.PointOfSale.Supplier;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    SupplierModel create(SupplierRequest supplierRequest);
    SupplierModel getSupplier(String id);
    List<SupplierModel> getAllSuppliers();
    SupplierModel update(String id ,SupplierRequest supplierRequest);
    void delete(String id);
}
