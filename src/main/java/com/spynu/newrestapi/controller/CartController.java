package com.spynu.newrestapi.controller;

import com.spynu.newrestapi.entity.CartItem;
import com.spynu.newrestapi.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Api(tags = "Корзина")
public class CartController {
    CartService cartService;

    @ApiOperation(value = "Показать корзину")
    @GetMapping("/showCart")
    public List<CartItem> showCart() {
        return cartService.getCartItems();
    }

    @ApiOperation(value = "Добавить товар в корзину")
    @PostMapping("/addProduct/{productId}/{quantity}")
    public ResponseEntity<?> addProductToCart(@PathVariable Long productId, @PathVariable int quantity) {
        cartService.addToCart(productId, quantity);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Удалить товар из корзины")
    @DeleteMapping("/removeProduct/{cartItemId}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.ok().build();
    }
}
