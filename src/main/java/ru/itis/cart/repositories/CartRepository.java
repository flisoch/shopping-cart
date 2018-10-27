package ru.itis.cart.repositories;

import ru.itis.cart.entities.Cart;

public interface CartRepository {
    void create(Cart cart);

    Cart getCartByHashUser(String value);

    void updateProductCount(Long cartId, Long productId, Long productCount);

    void cartAddProduct(Long cartId, Long productId);

    void deleteProduct(Long cartId, Long productId);
}
