package com.agronxt.productapi.service;

import com.agronxt.productapi.model.Product;
import com.agronxt.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        // product.setQuantity(productDetails.getQuantity());
        product.setBrand(productDetails.getBrand());
        product.setSlug(productDetails.getSlug());
        product.setImage(productDetails.getImage());
        product.setFeatured(productDetails.isFeatured());
        product.setRating(productDetails.getRating());
        product.setNotes(productDetails.getNotes());
        product.setTags(productDetails.getTags());
        product.setMood(productDetails.getMood());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
