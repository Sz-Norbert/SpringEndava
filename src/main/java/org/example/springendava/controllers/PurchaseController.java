package org.example.springendava.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springendava.dao.PurchaseRepository;
import org.example.springendava.models.Purchase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;


    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();
    }

}
