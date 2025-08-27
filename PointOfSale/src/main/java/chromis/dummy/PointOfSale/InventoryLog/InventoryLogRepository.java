package chromis.dummy.PointOfSale.InventoryLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InventoryLogRepository extends JpaRepository<InventoryLogModel, String> {
}
