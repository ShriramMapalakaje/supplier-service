package org.example.supplierservice.service;

import org.example.supplierservice.constants.SystemConstant;
import org.example.supplierservice.dtos.requests.OnboardSupplierRequest;
import org.example.supplierservice.enums.*;
import org.example.supplierservice.model.Employee;
import org.example.supplierservice.model.SupplierCompany;
import org.example.supplierservice.repositories.SupplierCompanyRepo;
import org.example.supplierservice.transformers.CompanyTransformer;
import org.example.supplierservice.utilities.SystemUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupplierService {

    CompanyTransformer companyTransformer;
    SupplierCompanyRepo supplierCompanyRepo;
    RoleService roleService;
    EmployeeService employeeService;

    @Autowired
    public SupplierService(CompanyTransformer companyTransformer,
                           SupplierCompanyRepo supplierCompanyRepo,
                           RoleService roleService,
                           EmployeeService employeeService){
        this.companyTransformer = companyTransformer;
        this.supplierCompanyRepo = supplierCompanyRepo;
        this.roleService = roleService;
        this.employeeService = employeeService;
    }


    public SupplierCompany onBoardSupplier(OnboardSupplierRequest onboardSupplierRequest){
        SupplierCompany supplierCompany = companyTransformer.transformOnBoardSupplierRequestToSupplierCompany(onboardSupplierRequest);
        supplierCompany = supplierCompanyRepo.save(supplierCompany);
        this.createAdminUserForSupplier(supplierCompany);
        return supplierCompany;
    }
    public Employee createAdminUserForSupplier(SupplierCompany supplierCompany){
        Employee employee = Employee.builder()
                .id(SystemUtility.generateIdForEntity(SystemConstant.USER_ENTITY_NAME))
                .employeeId(SystemUtility.generateIdForEntity(SystemConstant.EMPLOYEE_ENTITY_NAME))
                .email(supplierCompany.getEmail())
                .accountLocked(false)
                .company(supplierCompany)
                .deleted(false)
                .designation("SYSTEM_ADMIN")
                .emailVerified(false)
                .employmentStatus(EmploymentStatus.ACTIVE)
                .failedLoginAttempts(0)
                .firstName("SYSTEM")
                .lastName("ADMIN")
                .lastLoginAt(LocalDateTime.now())
                .lastLoginIp(SystemUtility.getClientIp())
                .userType(UserType.SUPPLIER_USER)
                .employmentType(EmploymentType.FULL_TIME)
                .language(Language.ENGLISH)
                .mfaEnabled(false)
                .timezone(TimeZone.UTC)
                .preferredCurrency(Currency.INR)
                .password(SystemUtility.generatePassword(SystemConstant.DEFAULT_PASSWORD_LENGTH))
                .status(UserStatus.ACTIVE)
                .profilePictureUrl(SystemConstant.SYSTEM_DEFAULT_PROFILE_PIC_URL)
                .phoneNumber(supplierCompany.getPhone())
                .roles(List.of(roleService.createSupplierAdminUserRole(supplierCompany)))
                .build();

        SystemUtility.setGlobalRecordsValue(employee);

        return employeeService.saveEmployee(employee);

    }

}
