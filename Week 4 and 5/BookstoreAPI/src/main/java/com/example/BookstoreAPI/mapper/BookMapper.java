package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.model.Book;

public interface BookMapper {
    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);
}
