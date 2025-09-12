package chromis.dummy.PointOfSale.layout;

import chromis.dummy.PointOfSale.views.CustomerView;
import chromis.dummy.PointOfSale.views.ProductView;
import chromis.dummy.PointOfSale.views.HomeView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    // 🔹 Top header with logo/title
    private void createHeader() {
        H1 logo = new H1("POS System");
        logo.getStyle()
                .set("font-size", "1.5em")
                .set("margin", "0");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.setPadding(true);
        header.addClassName("header");

        addToNavbar(header); // adds top bar
    }

    // 🔹 Side menu with navigation links
    private void createDrawer() {
        RouterLink homeLink = new RouterLink("Home", HomeView.class);
        RouterLink productLink = new RouterLink("Products", ProductView.class);
        RouterLink customerLink = new RouterLink("Customers", CustomerView.class);
        // RouterLink salesLink = new RouterLink("Sales", SaleView.class);
        // RouterLink reportsLink = new RouterLink("Reports", ReportView.class);

        VerticalLayout menu = new VerticalLayout(
                new Span("Navigation"),
                homeLink,
                productLink,
                customerLink
                // salesLink,
                // reportsLink
        );

        menu.setSizeFull();
        menu.setPadding(false);
        menu.setSpacing(false);
        menu.addClassName("menu");

        addToDrawer(menu); // adds side drawer
    }
}
