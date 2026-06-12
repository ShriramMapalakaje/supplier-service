package org.example.supplierservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SuperBuilder
public class Department extends GlobalRecord {
    private String id;
    private String name;
}