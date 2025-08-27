package chromis.dummy.PointOfSale.SaleItem;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SaleItemServiceImpl implements SaleItemService{
    private final SaleItemRepository saleItemRepository;

    @Override
    public SaleItemModel create(SaleItemRequest saleItemRequest){
        SaleItemModel saleItemModel = new SaleItemModel();
        return saleItemRepository.save(saleItemModel);
    }
    @Override
    public List<SaleItemModel> getAllSaleItems(){
        return saleItemRepository.findAll();

    }

    @Override
    public SaleItemModel getSaleItemById(String id){
        return saleItemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("SaleItem not found by id:"+ id));

    }

    @Override
    public SaleItemModel update(String id,SaleItemRequest saleItemRequest){
        SaleItemModel existing = saleItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SaleItem not found by id:"+ id));



        existing.setDescription(saleItemRequest.description());
        existing.setQuantity(saleItemRequest.quantity());
        existing.setPrice(saleItemRequest.price());

        return saleItemRepository.save(existing);

    }

    @Override
    public void delete(String id){
        if (!saleItemRepository.existsById(id)) {
            throw new RuntimeException("SaleItem not found with ID: " + id);
        }
        saleItemRepository.deleteById(id);

    }

}

