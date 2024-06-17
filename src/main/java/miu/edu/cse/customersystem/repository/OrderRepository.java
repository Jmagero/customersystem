package miu.edu.cse.customersystem.repository;

import miu.edu.cse.customersystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //Optional<Order> findByOrderByCustomer(Long orderId);
}
