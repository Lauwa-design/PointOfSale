package chromis.dummy.PointOfSale.Payment;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public PaymentModel create(PaymentRequest paymentRequest ){
        PaymentModel paymentModel = new PaymentModel();
        return paymentRepository.save(paymentModel);


    }
    @Override
    public List<PaymentModel> getAll(){
        return paymentRepository.findAll();

    }
    @Override
    public PaymentModel getPaymentModelById(String id){
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));

    }
    @Override
    public PaymentModel update(String id,PaymentRequest paymentRequest){

        PaymentModel existing = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));

        // Update fields from request
        existing.setAmount(paymentRequest.amount());
        existing.setPaymentMethod(paymentRequest.paymentMethod());

        return paymentRepository
                .save(existing);

    }
    @Override
    public void delete(String id){
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not found with ID: " + id);
        }
        paymentRepository
                .deleteById(id);
    }
}
