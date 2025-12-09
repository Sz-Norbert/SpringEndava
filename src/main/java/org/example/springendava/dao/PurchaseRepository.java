package org.example.springendava.dao;

import lombok.RequiredArgsConstructor;
import org.example.springendava.models.Purchase;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    public void storePurchase(Purchase purchase) {
        jdbc.update(
                "INSERT INTO purchase (product, price) VALUES (?, ?)",
                purchase.getProduct(),
                purchase.getPrice()
        );
    }

    public List<Purchase> findAllPurchases() {
        String sql =
        "SELECT * FROM purchase";

        RowMapper<Purchase> rowMapper = (r,i) -> {
            Purchase purchase = new Purchase();
            purchase.setId(r.getInt("id"));
            purchase.setProduct(r.getString("product"));
            purchase.setPrice(r.getBigDecimal("price"));
            return purchase;
        };
        return jdbc.query(sql, rowMapper);
    }

}
