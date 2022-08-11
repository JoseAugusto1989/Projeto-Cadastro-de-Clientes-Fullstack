package com.ciandt.fullstack.project.controller;

import com.ciandt.fullstack.project.model.Product;
import com.ciandt.fullstack.project.repository.ProductRepository;
import com.ciandt.fullstack.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

//    @PutMapping("/product")
//    public Product updateProduct(@RequestBody Product product) {
//        return productRepository.save(product);
//    }

    @PutMapping("/product")
    private ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
