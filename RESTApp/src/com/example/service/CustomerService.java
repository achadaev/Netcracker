package com.example.service;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(int id) {
        return customerRepository.findById(id);
    }

    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> update(Customer customer) {
        customerRepository.update(customer.getSurname(), customer.getLivingArea(), customer.getDiscount(), customer.getId());
        return getAll();
    }

    public List<Customer> patch(Customer customer) {
        customerRepository.update(customer.getSurname(), customer.getLivingArea(), customer.getId());
        return getAll();
    }

    public List<Customer> delete(int id) {
        customerRepository.deleteById(id);
        return getAll();
    }

    public List<String> getAreas() {
        return customerRepository.getAreas();
    }

    public List<Object[]> getAreaDiscount(String area) {
        return customerRepository.getAreaDiscount(area);
    }

}
