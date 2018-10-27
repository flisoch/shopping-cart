package ru.itis.cart.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.cart.entities.Cart;
import ru.itis.cart.entities.Product;
import ru.itis.cart.helpers.Pair;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CartRepositoryImpl implements CartRepository {
    //language=SQL
    private static final String SQL_INSERT = "INSERT into cart(hash_user) values (?)";
    private static final String SQL_SELECT_BY_HASH_USER = "SELECT * FROM cart WHERE hash_user = ?";
    private static final String SELECT_PRODUCT_COUNT = "SELECT cart_id, hash_user,product_id, count FROM product_cart AS pc JOIN cart AS c on pc.cart_id = c.id WHERE c.hash_user = ?";


    private RowMapper<Cart> cartRowMapper = (resultSet, i) -> Cart.builder()
            .id(resultSet.getLong("id"))
            .hashUser(resultSet.getString("hash_user"))
            .build();

    private RowMapper<Pair<Long,Integer>> cartRowMapperWithProductCounts = (resultSet, i) ->
         new Pair<Long, Integer>(resultSet.getLong("product_id"),resultSet.getInt("count"));





    JdbcTemplate jdbcTemplate;
    public CartRepositoryImpl(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(Cart cart) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_INSERT, new String[] {"id"});
                    ps.setString(1, cart.getHashUser());
                    return ps;
                }, keyHolder);

        cart.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Cart getCartByHashUser(String user) {
        Cart cart =  Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_HASH_USER, cartRowMapper, user)).orElse(null);
        List<Pair<Long,Integer>> list = jdbcTemplate.query(SELECT_PRODUCT_COUNT,cartRowMapperWithProductCounts, cart.getHashUser());
        HashMap<Long,Integer> map = new HashMap<>();
        for(Pair pair: list){
            map.put((Long)pair.getKey(),(Integer)pair.getValue());
        }
        System.out.println(map);
        cart.setProductsCount(map);
        return cart;
    }

}
