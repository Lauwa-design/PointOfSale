package chromis.dummy.PointOfSale.Price;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

       @Override
       public PriceModel create(PriceRequest priceRequest) {
           PriceModel priceModel = new PriceModel();
           return priceRepository.save(priceModel);
       }
       @Override
         public List<PriceModel> getAll(){
             return priceRepository.findAll();
       }
       @Override
       public  PriceModel getPriceById(String id){
             return priceRepository.findById(id)
                     .orElseThrow(() -> new RuntimeException("Price not found with ID :"+ id ));
       }
       @Override
       public PriceModel update(String id,PriceRequest priceRequest){
             PriceModel existing = priceRepository.findById(id)
                     .orElseThrow(() -> new RuntimeException("Price not found with ID :"+ id ));

             existing.setSellPrice(priceRequest.sellPrice());
             existing.setPriceListName(priceRequest.priceListName());
             existing.setValidFrom(priceRequest.validFrom());
             existing.setValidTo(priceRequest.validTo());

             return priceRepository
                     .save(existing);

        }
       @Override
       public void delete(String id){
             if (!priceRepository.existsById(id)) {
                 throw new RuntimeException("Cash session not found with ID: " + id);
             }
             priceRepository.deleteById(id);
       }



    }

