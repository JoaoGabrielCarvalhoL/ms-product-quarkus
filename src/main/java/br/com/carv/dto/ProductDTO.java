package br.com.carv.dto;

import br.com.carv.entity.ProductEntity;

import javax.persistence.Column;
import java.math.BigDecimal;

public class ProductDTO {

    private String name;

    private String description;

    private String category;

    private String model;

    private BigDecimal price;

    public ProductDTO() {

    }

    public ProductDTO(String name, String description, String category, String model, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.model = model;
        this.price = price;
    }

    public ProductDTO(ProductEntity entity) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.category = entity.getCategory();
        this.model = entity.getModel();
        this.price = entity.getPrice();
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
}
