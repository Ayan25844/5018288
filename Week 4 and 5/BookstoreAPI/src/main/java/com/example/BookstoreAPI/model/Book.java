package com.example.BookstoreAPI.entity;

import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "Book_Details")
@NamedQueries({
        @NamedQuery(name = "Book.getByIsbn", query = "SELECT b FROM Book b WHERE b.isbn=:isbn"),
        @NamedQuery(name = "Book.getByPrice", query = "SELECT b FROM Book b WHERE b.price=:price"),
        @NamedQuery(name = "Book.getByTitle", query = "SELECT b FROM Book b WHERE b.title=:title"),
        @NamedQuery(name = "Book.getByAuthor", query = "SELECT b FROM Book b WHERE b.author=:author")
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer price;
    private String title;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private String author;
}
