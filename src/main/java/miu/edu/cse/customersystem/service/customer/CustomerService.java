package miu.edu.cse.customersystem.service.customer;

import miu.edu.cse.customersystem.dto.CustomerRequestDto;
import miu.edu.cse.customersystem.dto.CustomerResponseDto;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerResponseDto> getCustomer(Long id);
    Optional<CustomerResponseDto> createCustomer(CustomerRequestDto customerRequestDto);

}
