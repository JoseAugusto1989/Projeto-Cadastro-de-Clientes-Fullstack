package com.ciandt.fullstack.project.service;

import com.ciandt.fullstack.project.model.Product;
import com.ciandt.fullstack.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // pega o preço de venda e subtrae pelo preço de compra, e chega-se ao lucro 'gain'
    private Double gainPerPiece(Double salePrice, Double purchasePrice) {
        return salePrice - purchasePrice;
    }

    public Product createProduct(Product product) {
        Double perPiece = gainPerPiece(product.getSalePrice(), product.getPurchasePrice());
        product.setGain(perPiece);
        return productRepository.save(product);
    }

}
