package org.example.supplierservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.supplierservice.dtos.requests.OnboardSupplierRequest;
import org.example.supplierservice.model.SupplierCompany;
import org.example.supplierservice.service.SupplierService;
import org.example.supplierservice.utilities.CommonLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    SupplierService supplierService;

    @Autowired
    public CompanyController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @PostMapping("/supplier/onboard")
    public ResponseEntity onboardSupplier(@RequestBody OnboardSupplierRequest onboardSupplierRequest){
        CommonLogger.log(CompanyController.class.getName(), "Received request for supplier : " + onboardSupplierRequest.toString(), CommonLogger.INFO);
        SupplierCompany supplierCompany = supplierService.onBoardSupplier(onboardSupplierRequest);
        return new ResponseEntity(supplierCompany, HttpStatus.CREATED);
    }

}
