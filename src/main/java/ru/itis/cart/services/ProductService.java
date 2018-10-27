package ru.itis.cart.services;

import ru.itis.cart.entities.Cart;
import ru.itis.cart.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    List<Product> getProductsByCart(Cart cart);
}
