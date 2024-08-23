package com.example.EmployeeManagementSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        if (employeeService.findAll() != null && !employeeService.findAll().isEmpty()) {
            return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("overview")
    public ResponseEntity<?> getEntryOverview() {
        if (employeeService.findAll() != null &&
                !employeeService.findAll().isEmpty()) {
            return new ResponseEntity<>(employeeService.getOverview(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("page/{no}")
    public ResponseEntity<?> getAll(@PathVariable int no) {
        if (employeeService.findAll() != null && !employeeService.findAll().isEmpty()) {
            Pageable pageable = PageRequest.of(no, 3);
            return new ResponseEntity<>(employeeService.findAll(pageable), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("sort/{field}")
    public ResponseEntity<?> getAll(@PathVariable String field) {
        if (employeeService.findAll() != null && !employeeService.findAll().isEmpty()) {
            return new ResponseEntity<>(employeeService.findAll(field), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("sort/{field}/page/{no}")
    public ResponseEntity<?> getAll(@PathVariable int no, @PathVariable String field) {
        if (employeeService.findAll() != null && !employeeService.findAll().isEmpty()) {
            Pageable pageable = PageRequest.of(no, 3, Sort.by(Sort.Direction.ASC, field));
            return new ResponseEntity<>(employeeService.findAll(pageable), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getEntry(@PathVariable Integer id) {
        if (employeeService.findById(id).isPresent()) {
            return new ResponseEntity<>(employeeService.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<?> getEntry(@PathVariable String name) {
        if (employeeService.findByName(name) != null && !employeeService.findByName(name).isEmpty()) {
            return new ResponseEntity<>(employeeService.findByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody Employee entry) {
        try {
            employeeService.save(entry);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable Integer id) {
        if (employeeService.findById(id).isPresent()) {
            employeeService.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("id/{id}")
    public ResponseEntity<Employee> updateEntry(@PathVariable Integer id, @RequestBody Employee entry) {
        Employee old = employeeService.findById(id).get();
        if (old != null) {
            old.setName(entry.getName() != null && !entry.getName().equals("") ? entry.getName() : old.getName());
            old.setEmail(entry.getEmail() != null && !entry.getEmail().equals("") ? entry.getEmail() : old.getEmail());
            old.setDepartment(entry.getDepartment() != null && entry.getDepartment().getId()!=null ? entry.getDepartment() : old.getDepartment());
            employeeService.save(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
