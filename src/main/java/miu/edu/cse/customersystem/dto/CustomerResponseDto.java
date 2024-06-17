package miu.edu.cse.customersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.customersystem.model.Order;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CustomerResponseDto {
    private Long id;
    private String name;
    private List<Order> orders;
}
