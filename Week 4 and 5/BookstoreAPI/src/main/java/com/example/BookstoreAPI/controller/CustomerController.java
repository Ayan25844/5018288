package com.example.BookstoreAPI.controller;

import org.springframework.http.HttpStatus;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import com.example.BookstoreAPI.dto.CustomerDTO;
import jakarta.persistence.EntityNotFoundException;
import com.example.BookstoreAPI.service.CustomerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody CustomerDTO entry) throws Exception {
        try {
            customerService.save(entry);
        } catch (Exception e) {
            throw new BadRequestException();
        }
        return new ResponseEntity<>(entry, HttpStatus.CREATED);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody CustomerDTO entry) {
        CustomerDTO old = customerService.getById(id);
        old.setName(
                entry.getName() != null && !entry.getName().equals("") ? entry.getName() : old.getName());
        old.setPassword(entry.getPassword() != null && !entry.getPassword().equals("") ? entry.getPassword()
                : old.getPassword());
        customerService.save(old);
        return new ResponseEntity<>(old, HttpStatus.OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            customerService.getById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
        customerService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
