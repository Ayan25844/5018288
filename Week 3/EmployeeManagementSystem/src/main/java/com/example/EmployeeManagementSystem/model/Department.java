package com.example.EmployeeManagementSystem.model;

import lombok.Data;
import java.util.Date;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EntityListeners;

@Data
@Entity
@Table(name = "departmentDetails")
@NamedQueries({
        @NamedQuery(name = "Department.findByName", query = "SELECT e FROM Department e WHERE e.name=:name")
})
@EntityListeners(AuditingEntityListener.class)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;
    @CreatedBy
    private String createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date LastModifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;

}
