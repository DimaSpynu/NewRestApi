package com.spynu.newrestapi.service;

import com.spynu.newrestapi.entity.Product;
import com.spynu.newrestapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public List<Product> getProductList() {
       return productRepository.findAll();
    }
}
