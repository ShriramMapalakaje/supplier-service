package org.example.supplierservice.dtos.requests;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.supplierservice.enums.Currency;
import org.example.supplierservice.enums.PaymentTerm;
import org.example.supplierservice.enums.SupplierType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OnboardSupplierRequest extends OnBoardCompanyRequest {

    private String supplierCode;
    private SupplierType supplierType;

    // Business Capability
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
    private String bankName;
    private String bankAccountNumber;
    private String swiftCode;
    private String iban;

    // Procurement Configuration
    private Boolean acceptsPurchaseOrders;
    private Boolean invoiceSubmissionEnabled;
    private Boolean ediEnabled;
    private Boolean catalogEnabled;

    // Diversity & Sustainability
    private Boolean diversitySupplier;
    private Boolean sustainabilityCertified;
    private String certifications;
}
