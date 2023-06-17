package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

  @GetMapping("/{id}")
  public ResponseEntity<?> getProductById(@PathVariable String id) {
    return ResponseEntity.ok(productService.getProductById(id));
  }

  @PostMapping
  public ResponseEntity<?> addProduct(@RequestBody Product product) {
    return ResponseEntity.ok(productService.addProduct(product));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteproduct(@PathVariable String id) {
    productService.deleteProduct(id);
    return ResponseEntity.ok("product deleted ");
  }

  @PutMapping("/{id}")
    public ResponseEntity <?> updateproduct(@RequestBody Product product,@PathVariable String id){
        return ResponseEntity.ok(productService.updateProduct(product,id));
    }
}