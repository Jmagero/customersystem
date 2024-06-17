package miu.edu.cse.customersystem.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.customersystem.dto.ProductRequestDto;
import miu.edu.cse.customersystem.dto.ProductResponseDto;
import miu.edu.cse.customersystem.service.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto product) {
        Optional<ProductResponseDto> productResponse = productService.create(product);
        if (productResponse.isPresent()) {
            return ResponseEntity.ok(productResponse.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        Optional<ProductResponseDto> productResponse = productService.findById(id);
        if (productResponse.isPresent()) {
            return ResponseEntity.ok(productResponse.get());
        }
        return ResponseEntity.notFound().build();
    }

}
