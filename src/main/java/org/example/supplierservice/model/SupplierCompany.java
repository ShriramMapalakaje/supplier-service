package org.example.supplierservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.supplierservice.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Data
@Entity
@Table(name = "supplier_companies")
public class SupplierCompany extends Company{
    private String supplierId;
    private String supplierCode;
    private SupplierType supplierType;

    private String supportedRegions;
    private Integer productionCapacityPerMonth;
    private Integer leadTimeInDays;
    private Integer yearsInBusiness;

    // Financial Information
    private BigDecimal minimumOrderValue;
    @Enumerated
    private Currency preferredCurrency;
    @Enumerated
    private PaymentTerm paymentTerm;

    // Banking & Payment
    private Boolean bankAccountVerified;
    private String bankName;
    private String bankAccountNumber;
    private String swiftCode;
    private String iban;

    // Procurement Configuration
    private Boolean acceptsPurchaseOrders;
    private Boolean invoiceSubmissionEnabled;
    private Boolean ediEnabled;
    private Boolean catalogEnabled;

    // Compliance & Verification
    private Boolean taxVerified;
    private Boolean insuranceVerified;
    private Boolean isoCertified;
    private Boolean ndaSigned;
    @Enumerated
    private ComplianceStatus complianceStatus;

    // Supplier Performance
    private Double supplierRating;
    private Double qualityScore;
    private Double deliveryScore;
    private Double responseScore;
    private Integer completedOrders;

    // Risk & Approval
    @Enumerated
    private RiskLevel riskLevel;
    @Enumerated
    private SupplierStatus supplierStatus;
    private Boolean blacklisted;

    // Contract Information
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private Boolean contractActive;
    // Diversity & Sustainability
    private Boolean diversitySupplier;
    private Boolean sustainabilityCertified;
    private String certifications;
    // Internal Metadata
    private String approvedBy;
    private LocalDateTime approvedAt;
    private LocalDateTime lastAuditDate;
    // Notes
    private String internalRemarks;
}
