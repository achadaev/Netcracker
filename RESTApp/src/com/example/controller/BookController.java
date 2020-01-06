package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    Book getById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON)
    List<Book> add(@RequestBody Book book) {
        bookService.add(book);
        return bookService.getAll();
    }

    @PatchMapping(value = "/patch", produces = MediaType.APPLICATION_JSON)
    List<Book> patch(@RequestBody Book book) {
        bookService.patch(book);
        return bookService.getAll();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON)
    List<Book> update(@RequestBody Book book) {
        bookService.update(book);
        return bookService.getAll();
    }

    @DeleteMapping("/delete")
    List<Book> delete(@RequestBody int id) {
        bookService.delete(id);
        return bookService.getAll();
    }

    @GetMapping("/names")
    List<Object[]> getNames() {
        return bookService.getNames();
    }

    @GetMapping("/win-exp")
    List<Object[]> getWindowsOrExpensiveBooks() {
        return bookService.getWindowsOrExpensiveBooks();
    }
}
