package com.example.EmployeeManagementSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.EmployeeManagementSystem.model.Department;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.EmployeeManagementSystem.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        if (departmentService.findAll() != null && !departmentService.findAll().isEmpty()) {
            return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("overview")
    public ResponseEntity<?> getOverview() {
        if (departmentService.findAll() != null && !departmentService.findAll().isEmpty()) {
            return new ResponseEntity<>(departmentService.getOverview(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("page/{no}")
    public ResponseEntity<?> getAll(@PathVariable int no) {
        if (departmentService.findAll() != null && !departmentService.findAll().isEmpty()) {
            Pageable pageable = PageRequest.of(no, 3);
            return new ResponseEntity<>(departmentService.findAll(pageable), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("sort/{field}")
    public ResponseEntity<?> getAll(@PathVariable String field) {
        if (departmentService.findAll() != null && !departmentService.findAll().isEmpty()) {
            return new ResponseEntity<>(departmentService.findAll(field), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("sort/{field}/page/{no}")
    public ResponseEntity<?> getAll(@PathVariable int no, @PathVariable String field) {
        if (departmentService.findAll() != null && !departmentService.findAll().isEmpty()) {
            Pageable pageable = PageRequest.of(no, 3, Sort.by(Sort.Direction.ASC, field));
            return new ResponseEntity<>(departmentService.findAll(pageable), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getEntry(@PathVariable Integer id) {
        if (departmentService.findById(id).isPresent()) {
            return new ResponseEntity<>(departmentService.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<?> getEntry(@PathVariable String name) {
        if (departmentService.findByName(name) != null && !departmentService.findByName(name).isEmpty()) {
            return new ResponseEntity<>(departmentService.findByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody Department entry) {
        try {
            departmentService.save(entry);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateEntry(@PathVariable Integer id, @RequestBody Department entry) {
        Department old = departmentService.findById(id).get();
        if (departmentService.findById(id).isPresent()) {
            old.setName(entry.getName() != null && !entry.getName().equals("") ? entry.getName() : old.getName());
            departmentService.save(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable Integer id) {
        if (departmentService.findById(id).isPresent()) {
            departmentService.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
