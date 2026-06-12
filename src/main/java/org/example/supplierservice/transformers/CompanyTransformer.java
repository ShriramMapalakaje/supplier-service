package org.example.supplierservice.transformers;

import org.example.supplierservice.constants.SystemConstant;
import org.example.supplierservice.dtos.requests.OnboardSupplierRequest;
import org.example.supplierservice.enums.CompanyStatus;
import org.example.supplierservice.enums.ComplianceStatus;
import org.example.supplierservice.enums.RiskLevel;
import org.example.supplierservice.enums.SupplierStatus;
import org.example.supplierservice.model.SupplierCompany;
import org.example.supplierservice.utilities.SystemUtility;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CompanyTransformer {

    public SupplierCompany transformOnBoardSupplierRequestToSupplierCompany(OnboardSupplierRequest onboardSupplierRequest){
        return SupplierCompany.builder()
                .diversitySupplier(onboardSupplierRequest.getDiversitySupplier())
                .supplierCode(onboardSupplierRequest.getSupplierCode())
                .supplierType(onboardSupplierRequest.getSupplierType())
                .supportedRegions(onboardSupplierRequest.getSupportedRegions())
                .productionCapacityPerMonth(onboardSupplierRequest.getProductionCapacityPerMonth())
                .leadTimeInDays(onboardSupplierRequest.getLeadTimeInDays())
                .yearsInBusiness(onboardSupplierRequest.getYearsInBusiness())
                .minimumOrderValue(onboardSupplierRequest.getMinimumOrderValue())
                .annualRevenue(onboardSupplierRequest.getAnnualRevenue())
                .preferredCurrency(onboardSupplierRequest.getPreferredCurrency())
                .paymentTerm(onboardSupplierRequest.getPaymentTerm())
                .bankAccountNumber(onboardSupplierRequest.getBankAccountNumber())
                .bankName(onboardSupplierRequest.getBankName())
                .swiftCode(onboardSupplierRequest.getSwiftCode())
                .iban(onboardSupplierRequest.getIban())
                .acceptsPurchaseOrders(onboardSupplierRequest.getAcceptsPurchaseOrders())
                .invoiceSubmissionEnabled(onboardSupplierRequest.getInvoiceSubmissionEnabled())
                .ediEnabled(onboardSupplierRequest.getEdiEnabled())
                .catalogEnabled(onboardSupplierRequest.getCatalogEnabled())
                .taxVerified(false)
                .insuranceVerified(false)
                .isoCertified(false)
                .ndaSigned(false)
                .complianceStatus(ComplianceStatus.UNDER_REVIEW)
                .supplierRating(0.0)
                .qualityScore(0.0)
                .deliveryScore(0.0)
                .responseScore(0.0)
                .completedOrders(0)
                .riskLevel(RiskLevel.GREEN)
                .supplierStatus(SupplierStatus.SUBMITTED_FOR_REVIEW)
                .blacklisted(false)
                .contractActive(false)
                .diversitySupplier(onboardSupplierRequest.getDiversitySupplier())
                .sustainabilityCertified(onboardSupplierRequest.getSustainabilityCertified())
                .legalName(onboardSupplierRequest.getLegalName())
                .displayName(onboardSupplierRequest.getDisplayName())
                .companyType(onboardSupplierRequest.getCompanyType())
                .taxId(onboardSupplierRequest.getTaxId())
                .companyRegistrationNumber(onboardSupplierRequest.getCompanyRegistrationNumber())
                .industry(onboardSupplierRequest.getIndustry())
                .website(onboardSupplierRequest.getWebsite())
                .email(onboardSupplierRequest.getEmail())
                .phone(onboardSupplierRequest.getPhone())
                .foundedYear(onboardSupplierRequest.getFoundedYear())
                .employeeCount(onboardSupplierRequest.getEmployeeCount())
                .annualRevenue(onboardSupplierRequest.getAnnualRevenue())
                .logoUrl(onboardSupplierRequest.getLogoUrl())
                .timeZone(onboardSupplierRequest.getTimeZone())
                .currency(onboardSupplierRequest.getCurrency())
                .language(onboardSupplierRequest.getLanguage())
                .companyStatus(CompanyStatus.UNDER_REVIEW)
                .companyId(SystemUtility.generateIdForEntity(SystemConstant.COMPANY_ENTITY_NAME))
                .supplierId(SystemUtility.generateIdForEntity(SystemConstant.SUPPLIER_COMPANY_ENTITY_NAME))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(SystemConstant.SYSTEM_USER)
                .updatedBy(SystemConstant.SYSTEM_USER)
                .build();

    }

}