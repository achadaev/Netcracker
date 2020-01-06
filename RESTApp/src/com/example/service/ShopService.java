package com.example.service;

import com.example.entity.Shop;
import com.example.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    public Shop getById(int id) {
        return shopRepository.findById(id);
    }

    public Shop add(Shop shop) {
        return shopRepository.save(shop);
    }

    public List<Shop> update(Shop shop) {
        shopRepository.update(shop.getName(), shop.getLocationArea(), shop.getCommission(), shop.getId());
        return getAll();
    }

    public List<Shop> patch(Shop shop) {
        shopRepository.update(shop.getLocationArea(), shop.getCommission(), shop.getId());
        return getAll();
    }

    public List<Shop> delete(int id) {
        shopRepository.deleteById(id);
        return getAll();
    }

}
