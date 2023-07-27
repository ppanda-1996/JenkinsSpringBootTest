package com.pallab.productservice.controller;

import com.pallab.productservice.dto.ProductRequest;
import com.pallab.productservice.dto.ProductResponse;
import com.pallab.productservice.productService.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    @Autowired
    private final ProductService productService;
    @PostMapping("/saveProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        log.info("product has been created in controller");
    }
    @GetMapping("/getAllProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }
}
