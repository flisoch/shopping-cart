package ru.itis.cart.services;

import ru.itis.cart.entities.Cart;
import ru.itis.cart.helpers.Pair;
import ru.itis.cart.repositories.CartRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CartServiceImpl implements CartService {
    CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void deleteProduct(Long cartId, Long productId) {
        cartRepository.deleteProduct(cartId,productId);
    }

    @Override
    public void updateCart(Long cartId, Long productId, Long productCount) {
        /*if(productCount == 0){
            cartRepository.deleteProduct(cartId,productId);
        }*/
        cartRepository.updateProductCount(cartId,productId,productCount);
    }

    @Override
    public void cartAddProduct(Long cartId, Long productId) {
        cartRepository.cartAddProduct(cartId,productId);
    }

    @Override
    public Cart getOrCreateCart(HttpServletRequest request, HttpServletResponse response) {
        Cart cart = null;
        if(request.getCookies() != null){
            Cookie cookie = Arrays.stream(request.getCookies()).filter(cookieVar -> cookieVar.getName().equals("hash_user")).findAny().orElse(null);
            if(cookie != null){
                cart = cartRepository.getCartByHashUser(cookie.getValue());
            }
        }

         else {
             cart = createCart(request);
             Cookie newCookie = new Cookie("hash_user",cart.getHashUser());
             newCookie.setMaxAge(30*24*60);
             response.addCookie(newCookie);
         }

        return cart;
    }

    private Cart createCart(HttpServletRequest request) {
        String session_id = request.getSession().getId();
        Cart cart = Cart.builder()
                .hashUser(session_id)
                .productsCount(new HashMap<Long, Integer>())
                .build();
        cartRepository.create(cart);
        return cart;

    }
}
