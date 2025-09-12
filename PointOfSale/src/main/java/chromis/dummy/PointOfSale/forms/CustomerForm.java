package chromis.dummy.PointOfSale.forms;

import chromis.dummy.PointOfSale.Customer.CustomerModel;
import chromis.dummy.PointOfSale.Customer.CustomerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.function.Consumer;

public class CustomerForm extends FormLayout {

    private final CustomerService customerService;
    private final Consumer<Void> onSaveCallback;

    private final TextField name = new TextField("Customer Name");
    private final EmailField email = new EmailField("Email");
    private final TextField phone = new TextField("Phone Number");



    private final CustomerModel customerModel;

    public CustomerForm(CustomerModel customerModel,
                        CustomerService customerService,
                        Consumer<Void> onSaveCallback) {
        Button save = new Button("Save");
        this.customerModel = customerModel;
        this.customerService = customerService;
        this.onSaveCallback = onSaveCallback;

        // Pre-fill if editing
        name.setValue(customerModel.getCustomerName() != null ? customerModel.getCustomerName() : "");
        email.setValue(customerModel.getEmail() != null ? customerModel.getEmail() : "");
        phone.setValue(customerModel.getPhoneNumber() != null ? customerModel.getPhoneNumber().toString() : "");

        save.addClickListener(e -> saveCustomer());

        add(name, email, phone, save);
    }

    private void saveCustomer() {
        customerModel.setCustomerName(name.getValue());
        customerModel.setEmail(email.getValue());
        customerModel.setPhoneNumber(Integer.valueOf(phone.getValue()));

        customerService.create(
                new chromis.dummy.PointOfSale.Customer.CustomerRequest(
                        customerModel.getCustomerName(),
                        customerModel.getEmail(),
                        customerModel.getPhoneNumber()
                )
        );

        Notification.show("Customer saved successfully");
        onSaveCallback.accept(null); // notify parent view
    }
}
