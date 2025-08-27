package chromis.dummy.PointOfSale.Payment;

import chromis.dummy.PointOfSale.Enums.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentRequest (

        BigDecimal amount,
        PaymentMethod paymentMethod

)
{
    public static PaymentModel toPaymentModel (PaymentRequest paymentRequest){
        return PaymentModel.builder()
                .amount(paymentRequest.amount())
                .paymentMethod(paymentRequest.paymentMethod())
                .build();
    }
}


