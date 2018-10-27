package ru.itis.cart.repositories;

import ru.itis.cart.entities.Cart;

public interface CartRepository {
    void create(Cart cart);

    Cart getCartByHashUser(String value);
}
