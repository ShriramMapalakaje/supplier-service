package org.example.supplierservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.supplierservice.enums.*;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "companies")
public class Company extends GlobalRecord{
    private String companyId;
    private String legalName;
    private String displayName;
    @Enumerated
    private CompanyType companyType;
    private String taxId;
    private String companyRegistrationNumber;
    @Enumerated
    private Industry industry;
    private String website;
    private String email;
    private String phone;
    private int foundedYear;
    private int employeeCount;
    private Double annualRevenue;
    private String logoUrl;
    @Enumerated
    private TimeZone timeZone; // ASIA_SRILANKA
    @Enumerated
    private Currency currency;
    @Enumerated
    private Language language;
    private CompanyStatus companyStatus;
}
