package com.example.controller;

import com.example.entity.Shop;
import com.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/all")
    List<Shop> getAll() {
        return shopService.getAll();
    }

    @GetMapping("/{id}")
    Shop getById(@PathVariable int id) {
        return shopService.getById(id);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    List<Shop> add(@RequestBody Shop shop) {
        shopService.add(shop);
        return shopService.getAll();
    }

    @PatchMapping(value = "/patch", produces = MediaType.APPLICATION_JSON)
    List<Shop> patch(@RequestBody Shop shop) {
        shopService.patch(shop);
        return shopService.getAll();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON)
    List<Shop> update(@RequestBody Shop shop) {
        shopService.update(shop);
        return shopService.getAll();
    }

    @DeleteMapping("/delete")
    List<Shop> delete(@RequestBody int id) {
        shopService.delete(id);
        return shopService.getAll();
    }

    @GetMapping("/discounted")
    List<Shop> getDiscountedShops() {
        return shopService.getDiscountedShops();
    }

}
