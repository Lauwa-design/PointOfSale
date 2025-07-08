package chromis.dummy.PointOfSale.ManyToMany;

import chromis.dummy.PointOfSale.Product.ProductModel;
import chromis.dummy.PointOfSale.Tax.TaxModel;
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
        name = "product_tax",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"product_model_id", "tax_model_id"})
        })

public class ProductTax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ProductModel productModel;

    @ManyToOne
    private TaxModel taxModel;
}
