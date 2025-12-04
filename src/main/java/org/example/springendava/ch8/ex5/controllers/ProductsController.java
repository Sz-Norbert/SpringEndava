package org.example.springendava.ch8.ex5.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springendava.ch8.ex5.models.Product;
import org.example.springendava.ch8.ex5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;



    @RequestMapping("/products")
    public String viewProducts(Model model){
        var products = productService.getProductList();
        model.addAttribute("products", products);

        return "products.html";
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct(
            Product product,
            Model model
    ){

        productService.addProduct(product);

        var products = productService.getProductList();
        model.addAttribute("products", products);

        return "products.html";

    }

}
