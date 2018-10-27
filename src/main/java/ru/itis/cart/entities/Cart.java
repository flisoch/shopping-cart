package ru.itis.cart.entities;

import lombok.Builder;
import lombok.Data;
import ru.itis.cart.helpers.Pair;

import java.util.HashMap;
import java.util.List;

@Builder
@Data
public class Cart {
    Long id;
    String hashUser;
    HashMap<Long,Integer> productsCount;
}
