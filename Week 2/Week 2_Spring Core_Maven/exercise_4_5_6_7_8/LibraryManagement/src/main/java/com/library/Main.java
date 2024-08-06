package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Create a main class to load the Spring context and test the configuration.
public class Main {
    public static void main(String[] args) {

        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService library = context.getBean(BookService.class);
        System.out.println(library.getService());

        // Run the LibraryManagementApplication main class to verify the dependency
        // injection.
        System.out.println(library.performService());

        BookRepository library_2 = context.getBean(BookRepository.class);
        System.out.println(library_2.getRepository());
    }
}