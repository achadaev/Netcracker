package com.example.controller;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    Customer getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    List<Customer> add(@RequestBody Customer customer) {
        customerService.add(customer);
        return customerService.getAll();
    }

    @PatchMapping(value = "/patch", produces = MediaType.APPLICATION_JSON)
    List<Customer> patch(@RequestBody Customer customer) {
        customerService.patch(customer);
        return customerService.getAll();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON)
    List<Customer> update(@RequestBody Customer customer) {
        customerService.update(customer);
        return customerService.getAll();
    }

    @DeleteMapping("/delete")
    List<Customer> delete(@RequestBody int id) {
        customerService.delete(id);
        return customerService.getAll();
    }

    @GetMapping("/areas")
    List<String> getAreas() {
        return customerService.getAreas();
    }

    // Try "Nizhegorodsky"
    @GetMapping("/{area}-discount")
    List<Object[]> getAreaDiscount(@PathVariable String area) {
        return customerService.getAreaDiscount(area);
    }

}
