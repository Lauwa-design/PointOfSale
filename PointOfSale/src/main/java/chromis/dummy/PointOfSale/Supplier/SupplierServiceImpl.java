package chromis.dummy.PointOfSale.Supplier;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SupplierServiceImpl implements SupplierService{
    private final SupplierRepository supplierRepository;

    @Override
    public SupplierModel create(SupplierRequest supplierRequest){
        SupplierModel supplierModel = new SupplierModel();
        return supplierRepository.save(supplierModel);
    }
    @Override
    public List<SupplierModel> getAllSuppliers(){
        return supplierRepository.findAll();

    }

    @Override
    public SupplierModel getSupplier(String id){
        return supplierRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Supplier not found by id:"+ id));

    }

    @Override
    public SupplierModel update(String id,SupplierRequest supplierRequest){
        SupplierModel existing = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found by id:"+ id));


        existing.setName(supplierRequest.name());
        existing.setContactPerson(supplierRequest.contactPerson());
        existing.setEmail(supplierRequest.email());
        existing.setPhoneNumber(supplierRequest.phoneNumber());
        existing.setAddress(supplierRequest.address());
        existing.setActive(supplierRequest.active());

        return supplierRepository.save(existing);

    }

    @Override
    public void delete(String id){
        if (!supplierRepository.existsById(id)) {
            throw new RuntimeException("Supplier not found with ID: " + id);
        }
       supplierRepository.deleteById(id);

    }

}

