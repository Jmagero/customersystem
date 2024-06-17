package miu.edu.cse.customersystem.service.order;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.customersystem.dto.CustomerResponseDto;
import miu.edu.cse.customersystem.dto.OrderRequestDto;
import miu.edu.cse.customersystem.dto.OrderResponseDto;
import miu.edu.cse.customersystem.model.Customer;
import miu.edu.cse.customersystem.model.Order;
import miu.edu.cse.customersystem.model.Product;
import miu.edu.cse.customersystem.repository.CustomerRepository;
import miu.edu.cse.customersystem.repository.OrderRepository;
import miu.edu.cse.customersystem.repository.ProductRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    public Optional<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto) {
        Optional<Customer> customer = customerRepository.findById(orderRequestDto.getCustomerId());
        List<Product> products = orderRequestDto.getProductName().stream()
                .map(name -> productRepository.findByName(name).get()).toList();
        if (customer.isPresent()) {
            Order order = new Order();
            order.setCustomer(customer.get());
            order.setOrderDate(LocalDate.now());
            order.setProducts(products);
            Order savedOrder = orderRepository.save(order);
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setOrderDate(savedOrder.getOrderDate());
//            CustomerResponseDto customerResponseDto = new CustomerResponseDto(
//                    customer.get().getId(),
//                    customer.get().getName(),
//                    customer.get().getOrders()
//            );
            orderResponseDto.setCustomerResponseDto(customer.get());
            return Optional.of(orderResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderResponseDto> findOrderByCustomerId(Long customerId) {
        Optional<Order> order = orderRepository.findById(customerId);
        if (order.isPresent()) {
            Order foundOrder = order.get();
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setOrderDate(foundOrder.getOrderDate());
            orderResponseDto.setCustomerResponseDto(foundOrder.getCustomer());
            return Optional.of(orderResponseDto);
        }
        return Optional.empty();
    }
}
