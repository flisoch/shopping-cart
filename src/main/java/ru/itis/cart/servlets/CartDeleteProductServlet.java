package ru.itis.cart.servlets;

import ru.itis.cart.services.CartService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart/delete/*")
public class CartDeleteProductServlet extends HttpServlet {

    CartService cartService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        cartService = (CartService) context.getAttribute("cartService");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cartId = Long.parseLong(req.getParameter("cart_id"));
        Long productId = Long.parseLong(req.getParameter("product_id"));
        cartService.deleteProduct(cartId,productId);
    }
}
