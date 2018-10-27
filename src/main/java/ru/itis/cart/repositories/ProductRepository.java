package ru.itis.cart.repositories;

import ru.itis.cart.entities.Cart;
import ru.itis.cart.entities.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();

    List<Product> getAllByCart(Cart cart);
}
