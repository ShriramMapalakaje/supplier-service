package org.example.supplierservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends GlobalRecord{
    private String id;
    @Column(unique = true, nullable = false)
    private String name; // COMPANYNAME_ROLENAME
    @ManyToMany
    private List<Operation> operations;
}