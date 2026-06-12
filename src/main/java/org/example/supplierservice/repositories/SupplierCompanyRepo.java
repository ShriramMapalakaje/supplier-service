package org.example.supplierservice.repositories;

import org.example.supplierservice.model.SupplierCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SupplierCompanyRepo extends JpaRepository<SupplierCompany, UUID> {
}