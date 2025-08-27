package chromis.dummy.PointOfSale.Customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerModel create(CustomerRequest customerRequest);
    List<CustomerModel> getAll();
    CustomerModel getCustomerById(String id);
    CustomerModel update(String id,CustomerRequest customerRequest);
    void deleteCustomer(String id);
}
