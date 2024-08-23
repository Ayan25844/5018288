package com.example.EmployeeManagementSystem.service;

import java.util.Optional;
import java.util.ArrayList;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.EmployeeManagementSystem.repository.EmployeeProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee entry) {
        employeeRepository.save(entry);
    }

    public ArrayList<Employee> findAll() {
        return new ArrayList<>(employeeRepository.findAll());
    }

    public ArrayList<EmployeeProjection> getOverview() {
        return employeeRepository.findAllBy();
    }

    public ArrayList<Employee> findAll(String field) {
        return new ArrayList<>(employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field)));
    }

    public Page<Employee> findAll(Pageable pageable) {
        Page<Employee> page = employeeRepository.findAll(pageable);
        return page;
    }

    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public ArrayList<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    public ArrayList<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public ArrayList<Employee> findByDepartmentId(Integer id) {
        return employeeRepository.findByDepartmentId(id);
    }

    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

}
