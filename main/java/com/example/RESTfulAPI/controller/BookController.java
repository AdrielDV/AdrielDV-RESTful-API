package com.example.RESTfulAPI.controller;

import com.example.RESTfulAPI.domain.Book;
import com.example.RESTfulAPI.repository.BookRepository;
import com.example.RESTfulAPI.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Entity")
public class BookController {

    @Autowired
    private BookServices services;

    @GetMapping
    public List<Book> getAll() {
        return services.getAllBooks();
    }

    @PostMapping
    public Book addNew(@RequestBody Book book) {
        return services.addNewBook(book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateEntity(@PathVariable Long id,
                                             String name,
                                             BigDecimal price,
                                             String date) {

        return ResponseEntity.ok(services.updateBook(id, name, price, date));
    }


    @DeleteMapping("/delete")
    public void deleteAll() {
        services.deleteAllBooks();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        services.deleteById(id);
    }


}

