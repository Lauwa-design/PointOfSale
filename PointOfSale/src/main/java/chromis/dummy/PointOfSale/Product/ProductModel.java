package chromis.dummy.PointOfSale.Product;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String productName;

    @Column(nullable = false, unique = true)
    private String barcode; // SKU or Barcode

    private String productDescription;

    @Column(precision = 10, scale = 2)
    private BigDecimal listPrice; // Standard or Manufacturer's Suggested Retail Price (MSRP)

    private Integer stockQuantity ;
    private Boolean trackInventory = true;//useless

    private Boolean active = true ; //use Prepersist



}

