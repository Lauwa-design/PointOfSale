package chromis.dummy.PointOfSale.views;

import chromis.dummy.PointOfSale.Customer.CustomerModel;
import chromis.dummy.PointOfSale.Customer.CustomerService;
import chromis.dummy.PointOfSale.forms.CustomerForm;
import chromis.dummy.PointOfSale.layout.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "customers", layout = MainLayout.class)
@PageTitle("Customers")
public class CustomerView extends VerticalLayout {

    private final CustomerService customerService;
    private final Grid<CustomerModel> grid = new Grid<>(CustomerModel.class);

    public CustomerView(CustomerService customerService) {
        this.customerService = customerService;

        Button addCustomer = new Button("Add Customer", e -> {
            CustomerForm form = new CustomerForm(
                    new CustomerModel(),
                    customerService,
                    v -> updateList()
            );
            add(form);
        });

        grid.setColumns("customerName", "email", "phoneNumber");

        add(addCustomer, grid);
        updateList();
    }

    private void updateList() {
        List<CustomerModel> customers = customerService.getAll();
        grid.setItems(customers);
    }
}
