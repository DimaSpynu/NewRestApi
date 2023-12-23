package com.spynu.newrestapi.service;

import com.spynu.newrestapi.entity.Product;
import com.spynu.newrestapi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ProductService {

    ProductRepository productRepository;

    public List<Product> getProductList() {
       return productRepository.findAll();
    }

    public Product createNewProduct() {
        Product product = new Product();
        productRepository.save(product);
        return product;
    }

    public Product showProductById(Long id) {
        return productRepository.findById(id);
    }

    public void updateProduct(Product updatedProduct) {
        productRepository.save(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
