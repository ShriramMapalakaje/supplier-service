package org.example.supplierservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.supplierservice.enums.EmploymentStatus;
import org.example.supplierservice.enums.EmploymentType;

import java.time.LocalDate;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier_employees")
public class Employee extends User {

    private String employeeId;

    @ManyToOne
    private Employee manager;

    @ManyToOne
    private Department department;

    private String designation;

    @Enumerated
    private EmploymentType employmentType;

    @Enumerated
    private EmploymentStatus employmentStatus;

    private LocalDate joiningDate;

    private LocalDate relievingDate;
}
