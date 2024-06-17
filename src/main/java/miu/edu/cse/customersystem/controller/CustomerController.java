package miu.edu.cse.customersystem.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.customersystem.dto.CustomerRequestDto;
import miu.edu.cse.customersystem.dto.CustomerResponseDto;
import miu.edu.cse.customersystem.service.customer.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        Optional<CustomerResponseDto> customerResponseDto = customerService.createCustomer(customerRequestDto);
        if (customerResponseDto.isPresent()) {
            return ResponseEntity.ok().body(customerResponseDto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> findCustomer(@PathVariable Long customerId) {
        Optional<CustomerResponseDto>customerResponseDto = customerService.getCustomer(customerId);
        if (customerResponseDto.isPresent()) {
            return ResponseEntity.ok().body(customerResponseDto.get());
        }
        return ResponseEntity.notFound().build();
    }
}
