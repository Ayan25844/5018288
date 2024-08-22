package com.example.EmployeeManagementSystem.repository;

import org.springframework.beans.factory.annotation.Value;

public interface DepartmentProjection {

    @Value("#{target.id}")
    public Long getId();

    @Value("#{target.name}")
    public String getName();

}
