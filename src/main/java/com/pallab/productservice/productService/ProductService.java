package com.pallab.productservice.productService;

import com.pallab.productservice.dto.ProductRequest;
import com.pallab.productservice.dto.ProductResponse;
import com.pallab.productservice.entity.Product;
import com.pallab.productservice.productRepository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product has been created successfully " + product.getName());
    }

    public List<ProductResponse> getAllProduct() {
        log.info("Retrieving all product from db");
        List<Product>productResponseList = productRepository.findAll();
        return productResponseList.stream().map(Product->mapToProductResponse(Product)).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
