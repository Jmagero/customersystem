package miu.edu.cse.customersystem.service.customer;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.customersystem.dto.CustomerRequestDto;
import miu.edu.cse.customersystem.dto.CustomerResponseDto;
import miu.edu.cse.customersystem.model.Customer;
import miu.edu.cse.customersystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<CustomerResponseDto> getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            Customer foundCustomer = customer.get();
            CustomerResponseDto customerResponseDto = CustomerResponseDto.builder()
                    .name(foundCustomer.getName())
                    .orders(foundCustomer.getOrders())
                    .id(foundCustomer.getId())
                    .build();
            return Optional.of(customerResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<CustomerResponseDto> createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setName(customerRequestDto.getName());
        customer.setOrders(customerRequestDto.getOrders());
        Customer savedCustomer = customerRepository.save(customer);
        CustomerResponseDto customerResponseDto =
                CustomerResponseDto.builder()
                        .name(savedCustomer.getName())
                        .orders(savedCustomer.getOrders())
                        .id(savedCustomer.getId())
                        .build();
        return Optional.of(customerResponseDto);
    }
}
