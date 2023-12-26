package com.spynu.newrestapi.controller;

import com.spynu.newrestapi.entity.Product;
import com.spynu.newrestapi.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Api(tags = "Товары")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;

    @ApiOperation(value = "Показать список товаров") //Протестировано - работает
    @GetMapping("/showProductList")
    public List<Product> showProductList() {
        return productService.getAllProducts();
    }

    @ApiOperation(value = "Показать форму создания товара") //Протестировано - работает
    @GetMapping("/showCreateForm")
    public Product showCreateForm() {
        return new Product();
    }

    @ApiOperation(value = "Создать товар") //Протестировано - работает
    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        productService.createNewProduct(product);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Показать форму редактирования товара") //Протестировано - работает
    @GetMapping("/{id}/showEditForm")
    public Product showEditForm(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @ApiOperation(value = "Редактировать товар") //Протестировано - работает
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Удалить товар") //Протестировано - работает
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}