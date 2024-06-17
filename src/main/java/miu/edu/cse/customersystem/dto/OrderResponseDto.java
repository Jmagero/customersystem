package miu.edu.cse.customersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.customersystem.model.Customer;
import miu.edu.cse.customersystem.model.Product;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderResponseDto {
    private LocalDate orderDate;
    private Customer customerResponseDto;
}
