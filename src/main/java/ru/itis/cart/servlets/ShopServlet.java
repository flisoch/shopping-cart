package ru.itis.cart.servlets;

import ru.itis.cart.entities.Cart;
import ru.itis.cart.entities.Product;
import ru.itis.cart.services.CartService;
import ru.itis.cart.services.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {


    ProductService productService;
    CartService cartService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        productService = (ProductService) context.getAttribute("productService");
        cartService = (CartService) context.getAttribute("cartService");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products = productService.getProducts();
        Cart cart = cartService.getOrCreateCart(request, response);
        int count = cart.getProductsCount().values().stream().reduce(0, (Integer a,Integer b) -> a + b);
        request.setAttribute("count", count);
        request.setAttribute("products",products);
        request.setAttribute("cart",cart);
        request.getRequestDispatcher("/jsp/shop.jsp").forward(request, response);

    }
}
