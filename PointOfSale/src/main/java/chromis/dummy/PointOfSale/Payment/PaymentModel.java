package chromis.dummy.PointOfSale.Payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data


public class PaymentModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;


    private BigDecimal amount;

    private LocalDateTime paymentDate;
    @PrePersist
    public void payDate() {
        paymentDate = LocalDateTime.now();

    }
    // private PaymentMethod paymentmethod;


}
