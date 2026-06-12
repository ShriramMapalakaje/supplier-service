package org.example.supplierservice.dtos.requests;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.supplierservice.enums.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OnBoardCompanyRequest {
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
}
