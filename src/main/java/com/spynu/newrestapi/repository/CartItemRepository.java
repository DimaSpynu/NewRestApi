package com.spynu.newrestapi.repository;

import com.spynu.newrestapi.entity.CartItem;
import com.spynu.newrestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByProduct(Product product);
}
