package miu.edu.cse.customersystem.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.customersystem.dto.OrderRequestDto;
import miu.edu.cse.customersystem.dto.OrderResponseDto;
import miu.edu.cse.customersystem.service.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{customerId}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable("customerId") Long customerId) {
        Optional<OrderResponseDto> orderResponseDto = orderService.findOrderByCustomerId(customerId);
        if (orderResponseDto.isPresent()) {
            return ResponseEntity.ok(orderResponseDto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        Optional<OrderResponseDto> orderResponseDto = orderService.createOrder(orderRequestDto);
        if (orderResponseDto.isPresent()) {
            return ResponseEntity.ok(orderResponseDto.get());
        }
        return ResponseEntity.notFound().build();
    }
}
