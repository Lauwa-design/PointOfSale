
package chromis.dummy.PointOfSale.Customer;


import com.vaadin.copilot.userinfo.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepository customerRepository;

    // CREATE
    @Override
    public CustomerModel create(CustomerRequest customerRequest) {
        CustomerModel model = CustomerRequest.toCustomerModel(customerRequest);
        return customerRepository.save(model);
    }

    // READ ALL
    @Override
    public List<CustomerModel> getAll() {
        return customerRepository.findAll();
    }

    // READ BY ID
    @Override
    public CustomerModel getCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    // UPDATE
    @Override
    public CustomerModel update(String id, CustomerRequest customerRequest) {
        CustomerModel existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));

        // Update fields from request

        existing.setCustomerName(customerRequest.customerName());
        existing.setEmail(customerRequest.email());
        existing.setPhoneNumber(customerRequest.phoneNumber());

        return customerRepository
                .save(existing); // @PreUpdate will set endTime
    }

    // DELETE
    @Override
    public void deleteCustomer(String id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        customerRepository
                .deleteById(id);
    }
}
