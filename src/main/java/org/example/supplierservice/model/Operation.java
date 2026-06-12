package org.example.supplierservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.supplierservice.enums.OperationCategory;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operations")
public class Operation extends GlobalRecord{
    private String id;
    @Column(unique = true, nullable = false)
    private String operationName;
    @Enumerated
    private OperationCategory operationCategory;
}