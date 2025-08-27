package chromis.dummy.PointOfSale.Price;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceService {
    PriceModel create(PriceRequest priceRequest);
    List<PriceModel> getAll();
    PriceModel getPriceById(String id);
    PriceModel update(String id,PriceRequest priceRequest);
    void delete(String id);

    
}
