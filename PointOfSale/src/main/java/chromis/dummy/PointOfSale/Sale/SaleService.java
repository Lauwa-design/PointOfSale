package chromis.dummy.PointOfSale.Sale;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleService {
    SaleModel create(SaleRequest saleRequest);
    List<SaleModel> getAll();
    SaleModel getById(String id);
    SaleModel update(String id,SaleRequest saleRequest);
    void delete(String id);

}
