package com.example.repository;

import com.example.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    List<Shop> findAll();

    Shop findById(int id);

    @Query(value = "UPDATE shop SET name = ?1, location_area = ?2, commission = ?3 " +
            "WHERE id = ?4", nativeQuery = true)
    void update(String name, String locationArea, double commission, int id);

    @Query(value = "UPDATE shop SET location_area = ?1, commission = ?2 " +
            "WHERE id = ?3", nativeQuery = true)
    void update(String surname, double commission, int id);

    @Query(value = "SELECT shop.id, shop.name, shop.location_area, shop.commission " +
            "FROM shop JOIN purchase ON shop.id = purchase.seller " +
            "JOIN customer ON purchase.customer = customer.id " +
            "WHERE shop.location_area != 'Avtozavodsky' " +
            "AND customer.discount BETWEEN 10 AND 15", nativeQuery = true)
    List<Shop> getDiscountedShops();

}
