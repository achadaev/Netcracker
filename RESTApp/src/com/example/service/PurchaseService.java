package com.example.service;

import com.example.entity.Purchase;
import com.example.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }

    public Purchase getById(int id) {
        return purchaseRepository.findById(id);
    }

    public Purchase add(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> update(Purchase purchase) {
        purchaseRepository.update(purchase.getDate(), purchase.getSeller(), purchase.getCustomer(), purchase.getBook(),
                purchase.getQuantity(), purchase.getAmount(), purchase.getOrderNumber());
        return getAll();
    }

    public List<Purchase> patch(Purchase purchase) {
        purchaseRepository.update(purchase.getQuantity(), purchase.getAmount(), purchase.getOrderNumber());
        return getAll();
    }

    public List<Purchase> delete(int id) {
        purchaseRepository.deleteById(id);
        return getAll();
    }

    public Set<String> getMonths() {
        Formatter formatter;
        Set<String> months = new HashSet<>();
        Calendar calendar = Calendar.getInstance();
        List<Date> dates = purchaseRepository.getDates();

        for (Date date : dates) {
            calendar.setTime(date);
            formatter = new Formatter();
            months.add(formatter.format("%tB", calendar).toString());
        }

        return months;
    }

    public List<Object[]> getSellersAndBuyers() {
        return purchaseRepository.getSellersAndBuyers();
    }

    public List<Object[]> getExtendedPurchaseInfo() {
        return purchaseRepository.getExtendedPurchaseInfo();
    }

    public List<Object[]> getExpensivePurchases() {
        return purchaseRepository.getExpensivePurchases();
    }

    public List<Object[]> getLocalPurchases() {
        return purchaseRepository.getLocalPurchases();
    }

    public List<Object[]> getStorageLocalPurchases() {
        return purchaseRepository.getStorageLocalPurchases();
    }

}
