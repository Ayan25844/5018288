// Create a package com.library.repository and add a class BookRepository.
package com.library.repository;

import org.springframework.stereotype.Repository;

// Use @Repository annotation for the BookRepository class.
@Repository
public class BookRepository {
    public String getRepository() {
        return ("Repository: getting book repository");
    }
}
