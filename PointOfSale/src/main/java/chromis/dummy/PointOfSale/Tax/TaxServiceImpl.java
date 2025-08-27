package chromis.dummy.PointOfSale.Tax;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TaxServiceImpl implements TaxService{
    private final TaxRepository taxRepository;

    @Override
    public TaxModel create(TaxRequest taxRequest){
        TaxModel taxModel = new TaxModel();
        return taxRepository.save(taxModel);
    }
    @Override
    public List<TaxModel> getAllTaxes(){
        return taxRepository.findAll();

    }

    @Override
    public TaxModel getTaxById(String id){
        return taxRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tax not found by id:"+ id));

    }

    @Override
    public TaxModel update(String id,TaxRequest taxRequest){
        TaxModel existing = taxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tax not found by id:"+ id));


        existing.setTaxName(taxRequest.taxName());
        existing.setRate(taxRequest.rate());
        existing.setIsDefault(taxRequest.isDefault());
        existing.setTicketStatus(taxRequest.ticketStatus());



        return taxRepository.save(existing);

    }
    @Override
    public void deleteTax(String id){
        if (!taxRepository.existsById(id)) {
            throw new RuntimeException("Tax not found with ID: " + id);
        }
        taxRepository.deleteById(id);

    }

}

