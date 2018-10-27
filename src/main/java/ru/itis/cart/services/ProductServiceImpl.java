package ru.itis.cart.services;

import ru.itis.cart.entities.Cart;
import ru.itis.cart.entities.Product;
import ru.itis.cart.repositories.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.getAll();
    }

    @Override
    public List<Product> getProductsByCart(Cart cart) {
        return productRepository.getAllByCart(cart);
    }
}
