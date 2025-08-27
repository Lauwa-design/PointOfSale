package chromis.dummy.PointOfSale.Sale;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SaleServiceImpl implements SaleService{
    private final SaleRepository saleRepository;

    @Override
    public SaleModel create(SaleRequest saleRequest){
        SaleModel saleModel = new SaleModel();
        return saleRepository.save(saleModel);
    }
    @Override
    public List<SaleModel> getAll(){
        return saleRepository.findAll();

    }

    @Override
    public SaleModel getById(String id){
        return saleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Sale not found by id:"+ id));

    }

    @Override
    public SaleModel update(String id,SaleRequest saleRequest){
        SaleModel existing = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found by id:"+ id));

        existing.setDescription(saleRequest.description());
        existing.setTaxAmount(saleRequest.taxAmount());
        existing.setTotalAmount(saleRequest.totalAmount());

        return saleRepository.save(existing);

    }

    @Override
    public void delete(String id){
        if (!saleRepository.existsById(id)) {
            throw new RuntimeException("Sale not found with ID: " + id);
        }
        saleRepository.deleteById(id);

    }

}

