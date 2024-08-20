package com.example.BookstoreAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private BookRepository bookRepository;

        @BeforeEach
        public void setUp() {
                bookRepository.deleteAll();
        }

        @Test
        public void testCreateAndGetBook() throws Exception {
                // Create a new book
                mockMvc.perform(MockMvcRequestBuilders.post("/books")
                                .contentType("application/json")
                                .content("{\"title\":\"Integration Book\", \"author\":\"Integration Author\", \"price\":10.99, \"isbn\":\"9876543210\"}"))
                                .andExpect(status().isCreated());

                // Retrieve the created book
                mockMvc.perform(MockMvcRequestBuilders.get("/books")
                                .contentType("application/json"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[0].title").value("Integration Book"))
                                .andExpect(jsonPath("$[0].author").value("Integration Author"));
        }

        @Test
        public void testUpdateBook() throws Exception {
                // Create a new book
                Book book = new Book();
                book.setTitle("Update Book");
                book.setAuthor("Update Author");
                book.setPrice(20.99);
                book.setIsbn("1234567890");
                book = bookRepository.save(book);

                // Update the book
                mockMvc.perform(MockMvcRequestBuilders.put("/books/{id}", book.getId())
                                .contentType("application/json")
                                .content("{\"title\":\"Updated Book\", \"author\":\"Updated Author\", \"price\":25.99, \"isbn\":\"1234567890\"}"))
                                .andExpect(status().isOk());

                // Retrieve the updated book
                mockMvc.perform(MockMvcRequestBuilders.get("/books/{id}", book.getId())
                                .contentType("application/json"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title").value("Updated Book"))
                                .andExpect(jsonPath("$.author").value("Updated Author"));
        }

        @Test
        public void testDeleteBook() throws Exception {
                // Create a new book
                Book book = new Book();
                book.setTitle("Delete Book");
                book.setAuthor("Delete Author");
                book.setPrice(30.99);
                book.setIsbn("1122334455");
                book = bookRepository.save(book);

                // Delete the book
                mockMvc.perform(MockMvcRequestBuilders.delete("/books/{id}", book.getId()))
                                .andExpect(status().isNoContent());

                // Attempt to retrieve the deleted book
                mockMvc.perform(MockMvcRequestBuilders.get("/books/{id}", book.getId()))
                                .andExpect(status().isNotFound());
        }
}
