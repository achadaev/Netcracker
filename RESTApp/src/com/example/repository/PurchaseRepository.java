package com.example.repository;

import com.example.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    List<Purchase> findAll();

    Purchase findById(int id);

    @Query(value = "UPDATE purchase SET date = ?1, seller = ?2, customer = ?3, book = ?4, quantity = ?5, amount = ?6 " +
            "WHERE id = ?7", nativeQuery = true)
    void update(Date date, int seller, int customer, int book, int quantity, double amount, int id);

    @Query(value = "UPDATE purchase SET quantity = ?1, amount = ?2 " +
            "WHERE id = ?3", nativeQuery = true)
    void update(int quantity, double amount, int id);

    @Query(value = "SELECT date FROM purchase", nativeQuery = true)
    List<Date> getDates();

    @Query(value = "SELECT order_number, customer.surname, shop.name " +
            "FROM purchase JOIN customer ON purchase.customer = customer.id " +
            "JOIN shop ON purchase.seller = shop.id", nativeQuery = true)
    List<Object[]> getSellersAndBuyers();

    @Query(value = "SELECT date, customer.surname, discount, book.name, purchase.quantity " +
            "FROM purchase JOIN customer ON purchase.customer = customer.id " +
            "JOIN book ON purchase.book = book.id", nativeQuery = true)
    List<Object[]> getExtendedPurchaseInfo();

    @Query(value = "SELECT order_number, customer.surname, date " +
            "FROM purchase JOIN customer ON purchase.customer = customer.id " +
            "WHERE amount >= 60000.0", nativeQuery = true)
    List<Object[]> getExpensivePurchases();

    @Query(value = "SELECT customer.surname, shop.location_area, date " +
            "FROM purchase JOIN customer ON purchase.customer = customer.id " +
            "JOIN shop ON purchase.seller = shop.id " +
            "WHERE customer.living_area = shop.location_area " +
            "AND EXTRACT(MONTH FROM date) > 3 " +
            "ORDER BY date", nativeQuery = true)
    List<Object[]> getLocalPurchases();

    @Query(value = "SELECT book.name, book.storage, purchase.quantity, purchase.amount " +
            "FROM book JOIN purchase ON book.id = purchase.book " +
            "JOIN shop ON purchase.seller = shop.id " +
            "WHERE book.storage = shop.location_area " +
            "AND book.quantity > 10 " +
            "ORDER BY purchase.amount", nativeQuery = true)
    List<Object[]> getStorageLocalPurchases();

}
