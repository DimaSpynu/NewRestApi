package com.spynu.newrestapi.controller;

import com.spynu.newrestapi.entity.Product;
import com.spynu.newrestapi.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products")
@ApiOperation(value = "Продукты")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getProductList")
    public List<Product> getProductList(Model model) {
        return productService.getProductList();
    }


}
