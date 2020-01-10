package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(int id) {
        return bookRepository.findById(id);
    }

    public Book add(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> update(Book book) {
        bookRepository.update(book.getName(), book.getPrice(), book.getStorage(), book.getQuantity(), book.getId());
        return getAll();
    }

    public List<Book> patch(Book book) {
        bookRepository.update(book.getPrice(), book.getStorage(), book.getQuantity(), book.getId());
        return getAll();
    }

    public List<Book> delete(int id) {
        bookRepository.deleteById(id);
        return getAll();
    }

    public List<Object[]> getNames() {
        return bookRepository.getNames();
    }

    public List<Object[]> getWindowsOrExpensiveBooks() {
        return bookRepository.getWindowsOrExpensiveBooks();
    }

}
