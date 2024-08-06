// Create a package com.library.service and add a class BookService.
package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public String getService() {
        return "getting book service";
    }

    // Ensure that BookService class has a setter method for BookRepository.
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String performService() {
        return "Performing service with book repository: " + this.bookRepository.getRepository();
    }
}
