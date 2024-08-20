package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDTO {
    public BookDTO(long l, String string, String string2, double d, String string3) {
        this.id = l;
        this.title = string;
        this.author = string2;
        this.price = d;
        this.isbn = string3;
    }

    @JsonProperty("id")
    private Long id;

    @JsonProperty("book_title")
    private String title;

    @JsonProperty("book_author")
    private String author;

    @JsonProperty("book_price")
    private Double price;

    @JsonProperty("book_isbn")
    private String isbn;
}
