package ru.itis.cart.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    Long id;
    String name;
    String description;
    Integer price;
}
