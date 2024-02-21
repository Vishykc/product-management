package com.viktorvranar.productmanagement.controller;

import com.viktorvranar.productmanagement.DTO.ProductRequest;
import com.viktorvranar.productmanagement.model.Product;
import com.viktorvranar.productmanagement.repository.ProductRepository;
import com.viktorvranar.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /* REST APIs as required in the task */


    @Autowired
    private ProductService productService;

    @PostMapping("/task")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.addProduct(productRequest);
        Product createdProduct = productRepository.save(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/task")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String code,
                                                     @RequestParam(required = false) String name) {
        List<Product> products;

        if (code != null && name != null) {
            // If both code and name parameters are provided
            products = productRepository.findByCodeContainingIgnoreCaseAndNameContainingIgnoreCase(code, name);
        } else if (code != null) {
            // If only code parameter is provided
            products = productRepository.findByCodeContainingIgnoreCase(code);
        } else if (name != null) {
            // If only name parameter is provided
            products = productRepository.findByNameContainingIgnoreCase(name);
        } else {
            // If no parameters are provided, return all products
            products = productRepository.findAll();
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

















    /* Usual CRUD APIs */

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productRepository.save(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));

        product.setCode(productDetails.getCode());
        product.setName(productDetails.getName());
        product.setPriceEUR(productDetails.getPriceEUR());
        product.setPriceUSD(productDetails.getPriceUSD());
        product.setDescription(productDetails.getDescription());

        Product updatedProduct = productRepository.save(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

