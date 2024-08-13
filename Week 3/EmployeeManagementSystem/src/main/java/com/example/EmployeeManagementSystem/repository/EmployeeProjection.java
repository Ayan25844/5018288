package com.example.EmployeeManagementSystem.repository;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    Long getId();

    String getName();

    String getEmail();

    @Value("#{target.department.name}")
    String getDepartmentName();
}
