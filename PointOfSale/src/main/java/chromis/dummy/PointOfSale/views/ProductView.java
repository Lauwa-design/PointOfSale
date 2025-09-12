package chromis.dummy.PointOfSale.views;

import chromis.dummy.PointOfSale.Product.ProductModel;
import chromis.dummy.PointOfSale.Product.ProductService;
import chromis.dummy.PointOfSale.forms.ProductForm;
import chromis.dummy.PointOfSale.layout.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "products", layout = MainLayout.class)  // this assumes you have a MainLayout
@PageTitle("Products | POS System")
public class ProductView extends VerticalLayout {

    private final ProductService productService;
    private final Grid<ProductModel> grid = new Grid<>(ProductModel.class, false); // false = no auto columns

    public ProductView(ProductService productService) {
        this.productService = productService;

        setSizeFull();
        configureGrid();

        Button addProductBtn = new Button("Add Product", e -> openForm(new ProductModel()));

        add(new HorizontalLayout(addProductBtn), grid);
        updateList();
    }

    private void configureGrid() {
        grid.addColumn(ProductModel::getProductName).setHeader("Name").setAutoWidth(true);
        grid.addColumn(ProductModel::getBarcode).setHeader("Barcode").setAutoWidth(true);
        grid.addColumn(ProductModel::getProductDescription).setHeader("Description").setAutoWidth(true);
        grid.addColumn(p -> p.getListPrice() != null ? p.getListPrice().toString() : "")
                .setHeader("Price").setAutoWidth(true);
        grid.addColumn(ProductModel::getStockQuantity).setHeader("Stock Qty").setAutoWidth(true);
        grid.addColumn(ProductModel::getActive).setHeader("Active").setAutoWidth(true);

        // Double-click row to edit product
        grid.addItemDoubleClickListener(event -> openForm(event.getItem()));
    }

    private void openForm(ProductModel product) {
        Dialog dialog = new Dialog();
        dialog.setWidth("400px");

        ProductForm form = new ProductForm(product, productService, v -> {
            updateList();
            dialog.close();
        });

        dialog.add(form);
        dialog.open();
    }

    private void updateList() {
        grid.setItems(productService.getAllProducts());
    }
}
