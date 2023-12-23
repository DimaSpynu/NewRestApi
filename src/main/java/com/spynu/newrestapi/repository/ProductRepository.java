package com.spynu.newrestapi.repository;

import com.spynu.newrestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(Long id);

    void deleteById(Long id);
}
