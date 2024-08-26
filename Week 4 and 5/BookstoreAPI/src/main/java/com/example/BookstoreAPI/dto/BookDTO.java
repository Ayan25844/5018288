package com.example.BookstoreAPI.dto;

import lombok.Data;

@Data
public class BookDTO {

    private Integer id;
    private String isbn;
    private String title;
    private Integer price;
    private String author;
}
