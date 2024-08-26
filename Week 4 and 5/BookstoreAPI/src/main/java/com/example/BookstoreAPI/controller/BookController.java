package com.example.BookstoreAPI.controller;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import com.example.BookstoreAPI.dto.BookDTO;
import org.springframework.data.domain.Sort;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import jakarta.persistence.EntityNotFoundException;
import com.example.BookstoreAPI.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody BookDTO entry) throws Exception {
        try {
            bookService.save(entry);
        } catch (Exception e) {
            throw new BadRequestException();
        }
        return new ResponseEntity<>(entry, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        if (bookService.getAll() != null && !bookService.getAll().isEmpty()) {
            return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
        } else {
            throw new NoSuchElementException();
        }
    }

    @GetMapping("page/{no}")
    public ResponseEntity<?> getAll(@PathVariable int no) {
        if (bookService.getAll() != null && !bookService.getAll().isEmpty()) {
            Pageable pageable = PageRequest.of(no, 3);
            return new ResponseEntity<>(bookService.getAll(pageable), HttpStatus.OK);
        } else {
            throw new NoSuchElementException();
        }
    }

    @GetMapping("sort/{field}")
    public ResponseEntity<?> getAll(@PathVariable String field) {
        if (bookService.getAll() != null && !bookService.getAll().isEmpty()) {
            return new ResponseEntity<>(bookService.getAll(field), HttpStatus.OK);
        } else {
            throw new NoSuchElementException();
        }
    }

    @GetMapping("sort/{field}/page/{no}")
    public ResponseEntity<?> getAll(@PathVariable int no, @PathVariable String field) {
        if (bookService.getAll() != null && !bookService.getAll().isEmpty()) {
            Pageable pageable = PageRequest.of(no, 3, Sort.by(Sort.Direction.ASC,
                    field));
            return new ResponseEntity<>(bookService.getAll(pageable), HttpStatus.OK);
        } else {
            throw new NoSuchElementException();
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (bookService.getById(id) != null) {
            return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
        } else {
            throw new NoSuchElementException();
        }
    }

    @GetMapping("author")
    public ResponseEntity<?> getByAuthor(@RequestParam String name) {
        if (bookService.getByAuthor(name) != null &&
                !bookService.getByAuthor(name).isEmpty()) {
            return new ResponseEntity<>(bookService.getByAuthor(name), HttpStatus.OK);
        } else {
            throw new NoSuchElementException();
        }
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody BookDTO entry) {
        BookDTO old = bookService.getById(id);
        old.setIsbn(entry.getIsbn() != null ? entry.getIsbn() : old.getIsbn());
        old.setPrice(entry.getPrice() != null ? entry.getPrice() : old.getPrice());
        old.setAuthor(
                entry.getAuthor() != null && !entry.getAuthor().equals("") ? entry.getAuthor() : old.getAuthor());
        old.setTitle(entry.getTitle() != null && !entry.getTitle().equals("") ? entry.getTitle() : old.getTitle());
        bookService.save(old);
        return new ResponseEntity<>(old, HttpStatus.OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            bookService.getById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
        bookService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
