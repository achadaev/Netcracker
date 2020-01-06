package com.example.controller;

import com.example.entity.Purchase;
import com.example.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/all")
    List<Purchase> getAll() {
        return purchaseService.getAll();
    }

    @GetMapping("/{id}")
    Purchase getById(@PathVariable int id) {
        return purchaseService.getById(id);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    List<Purchase> add(@RequestBody Purchase purchase) {
        purchaseService.add(purchase);
        return purchaseService.getAll();
    }

    @PatchMapping(value = "/patch", produces = MediaType.APPLICATION_JSON)
    List<Purchase> patch(@RequestBody Purchase purchase) {
        purchaseService.patch(purchase);
        return purchaseService.getAll();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON)
    List<Purchase> update(@RequestBody Purchase purchase) {
        purchaseService.update(purchase);
        return purchaseService.getAll();
    }

    @DeleteMapping("/delete")
    List<Purchase> delete(@RequestBody int id) {
        purchaseService.delete(id);
        return purchaseService.getAll();
    }

    @GetMapping("/months")
    Set<String> getMonths() {
        return purchaseService.getMonths();
    }

    @GetMapping("/sellers-buyers")
    List<Object[]> getSellersAndBuyers() {
        return purchaseService.getSellersAndBuyers();
    }

    @GetMapping("/extended")
    List<Object[]> getExtendedPurchaseInfo() {
        return purchaseService.getExtendedPurchaseInfo();
    }

    @GetMapping("/expensive")
    List<Object[]> getExpensivePurchases() {
        return purchaseService.getExpensivePurchases();
    }

    @GetMapping("/local")
    List<Object[]> getLocalPurchases() {
        return purchaseService.getLocalPurchases();
    }

    @GetMapping("/storage-local")
    List<Object[]> getStorageLocalPurchases() {
        return purchaseService.getStorageLocalPurchases();
    }

}
