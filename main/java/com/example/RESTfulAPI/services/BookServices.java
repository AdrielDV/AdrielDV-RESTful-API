package com.example.RESTfulAPI.services;

import com.example.RESTfulAPI.domain.Book;
import com.example.RESTfulAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServices {


    @Autowired
    BookRepository repository;


    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book addNewBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Long id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) BigDecimal price,
                           @RequestParam(required = false) String date) {
        Book bookUpdated = repository.findById(id).get();
        bookUpdated.setName(name != null ? name : bookUpdated.getName());
        bookUpdated.setDate(date != null ? date : bookUpdated.getDate());
        bookUpdated.setPrice(price != null ? price : bookUpdated.getPrice());
        repository.save(bookUpdated);
        return bookUpdated;

    }

    public void deleteAllBooks() {
        repository.deleteAll();
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}