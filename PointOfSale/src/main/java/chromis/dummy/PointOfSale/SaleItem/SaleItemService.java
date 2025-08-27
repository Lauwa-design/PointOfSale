package chromis.dummy.PointOfSale.SaleItem;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleItemService {
    SaleItemModel create(SaleItemRequest saleItemRequest);

    List<SaleItemModel> getAllSaleItems();

    SaleItemModel getSaleItemById(String id);

    SaleItemModel update(String id, SaleItemRequest saleItemRequest);

    void delete(String id);
}

