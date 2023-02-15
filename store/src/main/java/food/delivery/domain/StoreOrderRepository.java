package food.delivery.domain;

import food.delivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="storeOrders", path="storeOrders")
public interface StoreOrderRepository extends PagingAndSortingRepository<StoreOrder, Long>{
  Optional<StoreOrder> findByOrderId(Long orderId);
}
