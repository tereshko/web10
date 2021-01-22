package me.tereshko.web9.dto;

import lombok.Data;
import me.tereshko.web9.models.Product;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private double price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public ProductDto(ProductDto productDto) {
        this.id = productDto.getId();
        this.name = productDto.getName();
        this.price = productDto.getPrice();
    }
}
