package chromis.dummy.PointOfSale.Payment;

import chromis.dummy.PointOfSale.Enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record PaymentResponse (
     String id,
     BigDecimal amount,
     LocalDateTime paymentDate,
     PaymentMethod paymentMethod
)
{
    public static PaymentResponse fromPaymentModel(PaymentModel paymentModel){
        return new PaymentResponse(
                paymentModel.getId(),
                paymentModel.getAmount(),
                paymentModel.getPaymentDate(),
                paymentModel.getPaymentMethod()
        );
    }
}
