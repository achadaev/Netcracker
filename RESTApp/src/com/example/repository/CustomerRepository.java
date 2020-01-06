package com.example.repository;

import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();

    Customer findById(int id);

    @Query(value = "UPDATE customer SET surname = ?1, living_area = ?2, discount = ?3 " +
            "WHERE id = ?4", nativeQuery = true)
    void update(String surname, String livingArea, double discount, int id);

    @Query(value = "UPDATE customer SET surname = ?1, living_area = ?2 " +
            "WHERE id = ?3", nativeQuery = true)
    void update(String surname, String livingArea, int id);

    @Query(value = "SELECT living_area FROM customer", nativeQuery = true)
    List<String> getAreas();

    @Query(value = "SELECT surname, discount FROM customer WHERE living_area = ?1", nativeQuery = true)
    List<Object[]> getAreaDiscount(String area);

}
