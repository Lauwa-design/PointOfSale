package chromis.dummy.PointOfSale.Price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PriceRepository extends JpaRepository<PriceModel,String> {
}
