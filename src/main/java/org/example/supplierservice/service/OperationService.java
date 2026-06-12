package org.example.supplierservice.service;

import org.example.supplierservice.model.Operation;
import org.example.supplierservice.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public void saveAllOperations(List<Operation> operations){
        operationRepository.saveAll(operations);
    }


    public List<Operation> getSupplierAdminOperations(){
        // Will modify it later - For now giving all the application operations to supplier
        return operationRepository.findAll();
    }
}
