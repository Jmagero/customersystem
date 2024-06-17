package miu.edu.cse.customersystem.repository;

import miu.edu.cse.customersystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String productName);
    Optional<List<Product>> findAll(List<String> name);
}
