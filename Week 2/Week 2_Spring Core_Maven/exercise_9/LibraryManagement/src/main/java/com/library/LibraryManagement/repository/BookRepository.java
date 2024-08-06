package com.library.LibraryManagement.repository;

import com.library.LibraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// Create BookRepository interface.
public interface BookRepository extends JpaRepository<Book, Long> {
}