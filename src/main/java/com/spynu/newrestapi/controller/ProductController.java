package com.spynu.newrestapi.controller;

import com.spynu.newrestapi.entity.Product;
import com.spynu.newrestapi.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
@ApiOperation(value = "Продукты")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "Показать список товаров")
    @GetMapping("/getProductList")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.getProductList());
        return "product/product-list";
    }

    @ApiOperation(value = "Создать новый продукт")
    @PostMapping("/createProduct")
    public String createProduct(Model model) {
        model.addAttribute("product", productService.createNewProduct());
        return "product/product-create";
    }

    @ApiOperation(value = "Показать форму редактирования продукта")
    @GetMapping("/products/{id}/edit")
    public String showEditFormProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.showProductById(id);
        model.addAttribute("product", product);
        return "product/product-edit";
    }

    @ApiOperation(value = "Обновить продукт")
    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute Product product) {
        Product updatedProduct = productService.showProductById(id);
        if(updatedProduct != null) {
            productService.updateProduct(updatedProduct);
        }
        return "redirect:/products";
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

}
