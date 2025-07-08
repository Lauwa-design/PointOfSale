package chromis.dummy.PointOfSale.ManyToMany;

import chromis.dummy.PointOfSale.Category.CategoryModel;
import chromis.dummy.PointOfSale.Product.ProductModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(
        name = "product_category",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"product_model_id", "category_model_id"})
        })// prevents duplicates

public class ProductCategory {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;

    @ManyToOne
    private ProductModel productModel;

    @ManyToOne
    private CategoryModel categoryModel;

}
