package org.example.springendava.dao;

import lombok.RequiredArgsConstructor;
import org.example.springendava.mappers.AccountRowMapper;
import org.example.springendava.models.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        return  jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

}
