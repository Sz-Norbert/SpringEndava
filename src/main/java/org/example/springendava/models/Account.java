package org.example.springendava.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@Builder
public class Account {

    @Id


    private long id;

    private String name;
    private BigDecimal amount;

}
