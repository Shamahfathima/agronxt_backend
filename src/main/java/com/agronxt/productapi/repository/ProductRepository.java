package com.agronxt.productapi.repository;

import com.agronxt.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}