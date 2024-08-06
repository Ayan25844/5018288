// Create a package com.library.service and add a class BookService.
package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

// Use @Service annotation for the BookService class.
@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String getService() {
        return "getting book service";
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String performService() {
        return "Performing service with book repository: " +
                this.bookRepository.getRepository();
    }
}
