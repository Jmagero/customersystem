package miu.edu.cse.customersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import miu.edu.cse.customersystem.model.Order;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CustomerRequestDto {
    private String name;
    List<Order> orders;
}
