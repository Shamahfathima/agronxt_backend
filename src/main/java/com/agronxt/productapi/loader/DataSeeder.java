package com.agronxt.productapi.loader;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.agronxt.productapi.model.Product;
import com.agronxt.productapi.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            if (productRepository.count() == 0) {
                ObjectMapper mapper = new ObjectMapper();
                TypeReference<List<Product>> typeRef = new TypeReference<>() {
                };
                InputStream inputStream = getClass().getResourceAsStream("/products.json");
                if (inputStream == null)
                    throw new RuntimeException("products.json not found");

                List<Product> products = mapper.readValue(inputStream, typeRef);
                productRepository.saveAll(products);
                System.out.println("Products loaded into DB");
            }
        } catch (Exception e) {
            System.err.println("❌ Failed to seed data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
