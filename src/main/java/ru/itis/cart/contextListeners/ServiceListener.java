package ru.itis.cart.contextListeners;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.cart.repositories.CartRepository;
import ru.itis.cart.repositories.CartRepositoryImpl;
import ru.itis.cart.repositories.ProductRepository;
import ru.itis.cart.repositories.ProductRepositoryImpl;
import ru.itis.cart.services.CartService;
import ru.itis.cart.services.CartServiceImpl;
import ru.itis.cart.services.ProductService;
import ru.itis.cart.services.ProductServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ServiceListener implements ServletContextListener {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/cart";


    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        Class.forName("org.postgresql.Driver");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        ProductRepository productRepository = new ProductRepositoryImpl(dataSource);
        ProductService productService = new ProductServiceImpl(productRepository);
        CartRepository cartRepository = new CartRepositoryImpl(dataSource);
        CartService cartService = new CartServiceImpl(cartRepository);


        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("productService", productService);
        context.setAttribute("cartService", cartService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
