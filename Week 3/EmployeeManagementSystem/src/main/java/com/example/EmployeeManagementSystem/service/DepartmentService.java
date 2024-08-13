package com.example.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void batchSaveDepartments(List<Department> departments) {
        int batchSize = 50; // Example batch size
        for (int i = 0; i < departments.size(); i++) {
            departmentRepository.save(departments.get(i));
            if (i % batchSize == 0 && i > 0) {
                // Flush a batch of inserts and release memory
                departmentRepository.flush();
            }
        }
    }
}
