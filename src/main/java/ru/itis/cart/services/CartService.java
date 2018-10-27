package ru.itis.cart.services;

import ru.itis.cart.entities.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CartService {
    Cart getOrCreateCart(HttpServletRequest request, HttpServletResponse response);

    void updateCart(Long cartId, Long productId, Long productCount);

    void cartAddProduct(Long cartId, Long productId);
}
