package miu.edu.cse.customersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import miu.edu.cse.customersystem.model.Customer;
import miu.edu.cse.customersystem.model.Product;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderRequestDto {
    private Long customerId;
    private List<String> productName;
}
