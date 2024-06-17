package miu.edu.cse.customersystem.service.product;

import miu.edu.cse.customersystem.dto.ProductRequestDto;
import miu.edu.cse.customersystem.dto.ProductResponseDto;

import java.util.Optional;

public interface ProductService {
    Optional<ProductResponseDto> findById(Long id);
    Optional<ProductResponseDto> create(ProductRequestDto productRequestDto);

}
