package com.example.EmployeeManagementSystem.service;

import java.util.Optional;
import java.util.ArrayList;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.example.EmployeeManagementSystem.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.EmployeeManagementSystem.repository.DepartmentProjection;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void save(Department entry) {
        departmentRepository.save(entry);
    }

    public ArrayList<Department> findAll() {
        return new ArrayList<>(departmentRepository.findAll());
    }

    public ArrayList<DepartmentProjection> getOverview() {
        return departmentRepository.findAllBy();
    }

    public ArrayList<Department> findAll(String field) {
        return new ArrayList<>(departmentRepository.findAll(Sort.by(Sort.Direction.ASC, field)));
    }

    public Page<Department> findAll(Pageable pageable) {
        Page<Department> page = departmentRepository.findAll(pageable);
        return page;
    }

    public Optional<Department> findById(Integer id) {
        return departmentRepository.findById(id);
    }

    public ArrayList<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }

}
