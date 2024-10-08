package com.example.EmployeeManagementSystem.repository;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    @Value("#{target.id}")
    public Integer getId();

    @Value("#{target.name}")
    public String getName();

    @Value("#{target.email}")
    public String getEmail();

    @Value("#{target.department.name}")
    public String getDepartmentName();
}
