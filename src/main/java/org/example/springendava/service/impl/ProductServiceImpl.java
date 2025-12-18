package org.example.springendava.service.impl;

import org.example.springendava.mapper.ProductMapper;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springendava.dao.ProductRepository;
import org.example.springendava.dto.response.ProductResponse;
import org.example.springendava.entities.Product;
import org.example.springendava.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    @Transactional(readOnly = true)

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toResponseList(products);
    }
}
