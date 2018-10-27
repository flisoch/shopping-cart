package ru.itis.cart.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.cart.entities.Cart;
import ru.itis.cart.entities.Product;

import javax.sql.DataSource;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from product";
    //language=SQL
    private static final String SQL_SELECT_ALL_BY_CART_ID =
            "select p.id, p.name, p.description, p.price from product_cart pc join product p on pc.product_id = p.id WHERE pc.cart_id = ?";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .price(resultSet.getInt("price"))
            .description(resultSet.getString("description"))
            .build();

    @Override
    public List<Product> getAllByCart(Cart cart) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_CART_ID, productRowMapper, cart.getId());
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, productRowMapper);
    }
}
