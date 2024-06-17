package miu.edu.cse.customersystem.service.order;

import miu.edu.cse.customersystem.dto.OrderRequestDto;
import miu.edu.cse.customersystem.dto.OrderResponseDto;

import java.util.Optional;

public interface OrderService {
    Optional<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto);
    Optional<OrderResponseDto> findOrderByCustomerId(Long customerId);
}
