package com.example.BookstoreAPI.service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.mapper.BookMapper;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void save(BookDTO entry) {
        bookRepository.save(bookMapper.toBook(entry));
    }

    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public List<BookDTO> getAll(Pageable pageable) {
        List<BookDTO> page = bookRepository.findAll(pageable).stream().map(bookMapper::toDTO)
                .collect(Collectors.toList());
        return page;
    }

    public List<BookDTO> getAll(String field) {
        return new ArrayList<>(bookRepository.findAll(Sort.by(Sort.Direction.ASC,
                field))).stream().map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getById(Integer id) {
        return bookRepository.findById(id).map(bookMapper::toDTO).orElse(null);
    }

    public List<BookDTO> getByIsbn(String isbn) {
        return bookRepository.getByIsbn(isbn).stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public List<BookDTO> getByTitle(String title) {
        return bookRepository.getByTitle(title).stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public List<BookDTO> getByPrice(Integer price) {
        return bookRepository.getByPrice(price).stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public List<BookDTO> getByAuthor(String author) {
        return bookRepository.getByAuthor(author).stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

}
