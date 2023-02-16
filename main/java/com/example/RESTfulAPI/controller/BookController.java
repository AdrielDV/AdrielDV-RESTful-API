package com.example.RESTfulAPI.controller;

import com.example.RESTfulAPI.domain.Book;
import com.example.RESTfulAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @PostMapping
    public Book addNewBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,
                                              @RequestParam(required = false) String name,
                                              @RequestParam(required = false) BigDecimal price,
                                              @RequestParam(required = false) String date) {
        Book bookUpdated = repository.findById(id).get();
        bookUpdated.setName(name != null ? name : bookUpdated.getName());
        bookUpdated.setDate(date != null ? date : bookUpdated.getDate());
        bookUpdated.setPrice(price != null ? price : bookUpdated.getPrice());
        repository.save(bookUpdated);
        return ResponseEntity.ok(bookUpdated);
    }


    @DeleteMapping("/deleteBooks")
    public void deleteAllBooks(){
        repository.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }


}

