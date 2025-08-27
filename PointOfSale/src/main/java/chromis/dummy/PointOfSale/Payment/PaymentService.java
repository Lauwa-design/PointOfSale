package chromis.dummy.PointOfSale.Payment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    PaymentModel create(PaymentRequest paymentRequest );
    List<PaymentModel> getAll();
    PaymentModel getPaymentModelById(String id);
    PaymentModel update(String id,PaymentRequest paymentRequest);
    void delete(String id);
}
