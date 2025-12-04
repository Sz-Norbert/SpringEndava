package org.example.springendava.ch8.ex5.services;

import org.example.springendava.ch8.ex5.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }

    public List<Product> getProductList(){
        return productList;
    }
}
