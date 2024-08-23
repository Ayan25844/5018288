package com.example.EmployeeManagementSystem.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeManagementSystem.repository.DepartmentProjection;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    public ArrayList<DepartmentProjection> findAllBy();

    @Query(name = "Department.findByName")
    public ArrayList<Department> findByName(@Param("name") String name);

}
