package com.example.BookstoreAPI.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.model.Customer;
import com.example.BookstoreAPI.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookResourceAssembler assembler;

    public BookController(BookService bookService, BookResourceAssembler assembler) {
        this.bookService = bookService;
        this.assembler = assembler;
    }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestHeader(value = HttpHeaders.ACCEPT, defaultValue = "application/json") String acceptHeader) {
        List<BookDTO> books = bookService.getAllBooks();

        if (acceptHeader.equals("application/xml")) {
            return ResponseEntity.ok()
                    .body(books); 
        } else {
            return ResponseEntity.ok()
                    .body(books);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.getBookById(id);
        if (bookDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assembler);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/customers")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Created customer with name " + customer.getName());
    }
}
