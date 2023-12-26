package com.spynu.newrestapi.service;

import com.spynu.newrestapi.entity.Product;
import com.spynu.newrestapi.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    ProductRepository productRepository;

    public void updateProduct(Product updatedProduct) {
        productRepository.save(updatedProduct);
    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void createNewProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }
}
