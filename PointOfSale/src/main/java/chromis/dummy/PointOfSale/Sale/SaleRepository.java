package chromis.dummy.PointOfSale.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SaleRepository extends JpaRepository<SaleModel, String> {
}
