package miu.edu.cse.customersystem.service.product;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.customersystem.dto.ProductRequestDto;
import miu.edu.cse.customersystem.dto.ProductResponseDto;
import miu.edu.cse.customersystem.model.Product;
import miu.edu.cse.customersystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Optional<ProductResponseDto> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product foundProduct = product.get();
            ProductResponseDto productResponseDto =
                    ProductResponseDto.builder()
                            .name(foundProduct.getName())
                            .price(foundProduct.getPrice())
                            .build();
            return Optional.of(productResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductResponseDto> create(ProductRequestDto productRequestDto) {
        Product product = new Product (productRequestDto.getName(), productRequestDto.getPrice());
        Product savedProduct = productRepository.save(product);
        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .build();
        return Optional.of(productResponseDto);
    }
}
