package chromis.dummy.PointOfSale.Product;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String productName;

    @Column(nullable = false, unique = true)
    private String barcode; // SKU or Barcode

    private String productDescription;

    @Column(precision = 10, scale = 2)
    private BigDecimal listPrice; // Standard or Manufacturer's Suggested Retail Price (MSRP)

    private int stockQuantity = 0;
    private boolean trackInventory = true;
    private boolean active = true;
}

