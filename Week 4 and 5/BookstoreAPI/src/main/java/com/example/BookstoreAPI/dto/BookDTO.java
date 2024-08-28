package com.example.BookstoreAPI.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookDTO extends RepresentationModel<BookDTO> {

    private Integer id;
    private String isbn;
    private String title;
    private Integer price;
    private String author;
}
