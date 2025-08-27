package chromis.dummy.PointOfSale.Tax;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaxService {
    TaxModel create(TaxRequest taxRequest);
    List<TaxModel> getAllTaxes();
    TaxModel getTaxById(String id);
    TaxModel update(String id ,TaxRequest taxRequest);
    void deleteTax(String id);
}
