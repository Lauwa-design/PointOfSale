package chromis.dummy.PointOfSale.Payment;

import chromis.dummy.PointOfSale.Enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class PaymentModel {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;


    private BigDecimal amount;

    private LocalDateTime paymentDate;
    @PrePersist
    public void payDate() {
        paymentDate = LocalDateTime.now();

    }
    private PaymentMethod paymentMethod;


}
