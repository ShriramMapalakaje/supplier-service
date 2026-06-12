package org.example.supplierservice.service;

import org.example.supplierservice.constants.SystemConstant;
import org.example.supplierservice.model.Operation;
import org.example.supplierservice.model.Role;
import org.example.supplierservice.model.SupplierCompany;
import org.example.supplierservice.repositories.RoleRepository;
import org.example.supplierservice.utilities.SystemUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    OperationService operationService;
    RoleRepository roleRepository;

    @Autowired
    public RoleService(OperationService operationService,
                       RoleRepository roleRepository){
        this.operationService = operationService;
        this.roleRepository = roleRepository;
    }

    public List<Operation> getSupplierAdminOperations(){
        return operationService.getSupplierAdminOperations();
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public Role createSupplierAdminUserRole(SupplierCompany supplierCompany){
        Role role = Role.builder()
                .id(SystemUtility.generateIdForEntity(SystemConstant.ROLE_ENTITY_NAME))
                .name(supplierCompany.getLegalName() + "_" + "SYS_ADMIN")
                .operations(this.getSupplierAdminOperations())
                .build();
        SystemUtility.setGlobalRecordsValue(role);
        return this.saveRole(role);
    }
}

