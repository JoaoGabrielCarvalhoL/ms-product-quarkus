package br.com.carv.entity;

import br.com.carv.dto.ProductDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String description;

    private String category;

    private String model;

    private BigDecimal price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, String category, String model, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.model = model;
        this.price = price;
    }

    public ProductEntity(ProductDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.category = dto.getCategory();
        this.model = dto.getModel();
        this.price = dto.getPrice();
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    private void setCreationDate() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    private void setUpdateDate() {
        setUpdatedAt(LocalDateTime.now());
    }
}
