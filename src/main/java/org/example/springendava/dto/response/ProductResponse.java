package org.example.springendava.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
}
