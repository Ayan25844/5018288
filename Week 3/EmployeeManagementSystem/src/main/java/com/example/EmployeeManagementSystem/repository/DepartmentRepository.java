package com.example.EmployeeManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(name = "Department.findByName")
    Department findByName(@Param("name") String name);

    @Query(name = "Department.findDepartmentsWithEmployeeCountGreaterThan")
    List<Department> findDepartmentsWithEmployeeCountGreaterThan(@Param("minEmployeeCount") Long minEmployeeCount);

    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    Optional<Employee> findByEmail(String email);

    @Query("SELECT d.id AS id, d.name AS name, " +
            "(SELECT COUNT(e) FROM Employee e WHERE e.department.id = d.id) AS employeeCount " +
            "FROM Department d")
    List<DepartmentProjection> findAllDepartmentProjections();

}