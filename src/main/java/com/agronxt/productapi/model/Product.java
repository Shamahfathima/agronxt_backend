package com.agronxt.productapi.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String slug;
    private String image;
    private double price;
    
    @Column(length = 1000)
    private String description;
    
    private double rating;
    private boolean featured;

    @ElementCollection
    private List<String> notes;

    @ElementCollection
    private List<String> tags;

    @ElementCollection
    private List<String> mood;

    // Getters and Setters (or use Lombok @Data)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    // public Integer getQuantity() {
    //     return quantity;
    // }
    // public void setQuantity(Integer quantity) {
    //     this.quantity = quantity;
    // }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public boolean isFeatured() {
        return featured;
    }
    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
    public List<String> getNotes() {
        return notes;
    }
    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public List<String> getMood() {
        return mood;
    }
    public void setMood(List<String> mood) {
        this.mood = mood;
    }
}
