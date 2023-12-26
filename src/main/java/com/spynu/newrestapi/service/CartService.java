package com.spynu.newrestapi.service;

import com.spynu.newrestapi.entity.CartItem;
import com.spynu.newrestapi.entity.Product;
import com.spynu.newrestapi.repository.CartItemRepository;
import com.spynu.newrestapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    CartItemRepository cartItemRepository;
    ProductRepository productRepository;

    public void addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId);
        if (product != null) {
            CartItem cartItem = cartItemRepository.findByProduct(product);
            if (cartItem != null) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
            } else {
                cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setQuantity(quantity);
            }
            cartItemRepository.save(cartItem);
        }
    }

    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    // Другие методы для обработки корзины товаров
}
