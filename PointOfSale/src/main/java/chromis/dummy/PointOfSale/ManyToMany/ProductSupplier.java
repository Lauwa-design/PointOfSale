package chromis.dummy.PointOfSale.ManyToMany;

import chromis.dummy.PointOfSale.Product.ProductModel;
import chromis.dummy.PointOfSale.Supplier.SupplierModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
        name = "product_supplier",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"product_model_id", "supplier_model_id"})
        })

public class ProductSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ProductModel productModel;

    @ManyToOne
    private SupplierModel supplierModel;




}
