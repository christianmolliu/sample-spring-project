package p466.taco_cloud.data;

import org.springframework.data.repository.CrudRepository;

import p466.taco_cloud.TacoOrder;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

}