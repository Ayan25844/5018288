package com.example.EmployeeManagementSystem.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    ArrayList<EmployeeProjection> findAllBy();

    @Query(name = "Employee.findByName")
    public ArrayList<Employee> findByName(@Param("name") String name);

    @Query(name = "Employee.findByEmail")
    public ArrayList<Employee> findByEmail(@Param("email") String email);

    @Query(name = "Employee.findByDepartmentId")
    public ArrayList<Employee> findByDepartmentId(@Param("id") Long id);
}
