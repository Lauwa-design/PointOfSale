package chromis.dummy.PointOfSale.views;

import chromis.dummy.PointOfSale.layout.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Dashboard")
public class HomeView extends VerticalLayout {

    public HomeView() {
        addClassName("home-view");
        setSizeFull();

        add(new H2("Welcome to POS System"));
        add(new Paragraph("Use the navigation menu to go to Products, Customers, Sales and Reports."));
    }
}
