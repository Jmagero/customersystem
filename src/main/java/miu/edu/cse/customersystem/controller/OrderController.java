package miu.edu.cse.customersystem.controller;

import miu.edu.cse.customersystem.dto.OrderResponseDto;
import miu.edu.cse.customersystem.service.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")

public class OrderController {
    private  OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/{customerId")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable("customerId") Long customerId) {
        Optional<OrderResponseDto> orderResponseDto = orderService.findOrderByCustomerId(customerId);
        if (orderResponseDto.isPresent()) {
            return ResponseEntity.ok(orderResponseDto.get());
        }
        return ResponseEntity.notFound().build();
    }
}
