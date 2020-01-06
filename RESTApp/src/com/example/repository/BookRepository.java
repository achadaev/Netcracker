package com.example.repository;

import com.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAll();

    Book findById(int id);

    @Query(value = "UPDATE book SET name = ?1, price = ?2, storage = ?3, quantity = ?4 " +
            "WHERE id = ?5", nativeQuery = true)
    void update(String name, double price, String storage, int quantity, int id);

    @Query(value = "UPDATE book SET price = ?1, storage = ?2, quantity = ?3 " +
            "WHERE id = ?4", nativeQuery = true)
    void update(double price, String storage, int quantity, int id);

    @Query(value = "SELECT name, price FROM book", nativeQuery = true)
    List<Object[]> getNames();

    @Query(value = "SELECT name, price FROM book WHERE name LIKE '%Windows%' OR price > 20000.0 " +
            "ORDER BY name, price DESC", nativeQuery = true)
    List<Object[]> getWindowsOrExpensiveBooks();

}
