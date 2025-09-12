package chromis.dummy.PointOfSale.forms;

import chromis.dummy.PointOfSale.Product.ProductModel;
import chromis.dummy.PointOfSale.Product.ProductRequest;
import chromis.dummy.PointOfSale.Product.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class ProductForm extends FormLayout {

    private final ProductService productService;
    private final Consumer<Void> onSaveCallback;

    private final TextField name = new TextField("Product Name");
    private final TextField barcode = new TextField("Barcode");
    private final TextField description = new TextField("Description");
    private final NumberField price = new NumberField("Price");
    private final NumberField stockQuantity = new NumberField("Stock Quantity");


    private final ProductModel productModel; // current product being edited

    public ProductForm(ProductModel productModel,
                       ProductService productService,
                       Consumer<Void> onSaveCallback) {
        Button save = new Button("Save");


        this.productModel = productModel;
        this.productService = productService;
        this.onSaveCallback = onSaveCallback;

        // Pre-fill fields if editing an existing product
        name.setValue(productModel.getProductName() != null ? productModel.getProductName() : "");
        barcode.setValue(productModel.getBarcode() != null ? productModel.getBarcode() : "");
        description.setValue(productModel.getProductDescription() != null ? productModel.getProductDescription() : "");
        price.setValue(productModel.getListPrice() != null ? productModel.getListPrice().doubleValue() : 0.0);
        stockQuantity.setValue(productModel.getStockQuantity() != null ? productModel.getStockQuantity().doubleValue() : 0.0);

        save.addClickListener(e -> saveProduct());

        add(name, barcode, description, price, stockQuantity, save);
    }

    private void saveProduct() {
        // convert safely
        BigDecimal priceVal = price.getValue() == null ? BigDecimal.ZERO
                : BigDecimal.valueOf(price.getValue());

        Integer qty = stockQuantity.getValue() == null ? 0
                : stockQuantity.getValue().intValue();

        ProductRequest productRequest = new ProductRequest(
                name.getValue(),
                barcode.getValue(),
                description.getValue(),
                priceVal,
                qty,
                true, // trackInventory - replace with a Checkbox if dynamic
                true  // active - replace with a Checkbox if dynamic
        );

        if (productModel.getId() == null) {
            productService.create(productRequest);
            Notification.show("Product created successfully");
        } else {
            productService.update(productModel.getId(), productRequest);
            Notification.show("Product updated successfully");
        }

        onSaveCallback.accept(null); // Refresh grid in parent view
    }
}
