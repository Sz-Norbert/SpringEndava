package org.example.springendava.service;

import jakarta.transaction.Transactional;
import org.example.springendava.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {


    List<ProductResponse> getAllProducts();
}
