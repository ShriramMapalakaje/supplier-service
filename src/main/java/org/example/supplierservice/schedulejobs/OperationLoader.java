package org.example.supplierservice.schedulejobs;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.example.supplierservice.constants.SystemConstant;
import org.example.supplierservice.enums.OperationCategory;
import org.example.supplierservice.model.Operation;
import org.example.supplierservice.service.OperationService;
import org.example.supplierservice.utilities.SystemUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationLoader {

    @Autowired
    private OperationService operationService;

    /**
     * Runs only once during application startup
     */
    @PostConstruct
    @Transactional
    public void loadAllOperationsInSystem(){
        List<Operation> operations = this.getOperationObjects();
        operationService.saveAllOperations(operations);
    }

    public List<Operation> getOperationObjects(){
        List<Operation> operations = List.of(
                // Supplier Operations
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_SUPPLIER", OperationCategory.SUPPLIER_ONBOARDING),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPDATE_SUPPLIER", OperationCategory.SUPPLIER_ONBOARDING),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "DELETE_SUPPLIER", OperationCategory.SUPPLIER_ONBOARDING),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "VIEW_SUPPLIER", OperationCategory.SUPPLIER_ONBOARDING),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "APPROVE_SUPPLIER", OperationCategory.SUPPLIER_VERIFICATION),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "REJECT_SUPPLIER", OperationCategory.SUPPLIER_VERIFICATION),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "BLOCK_SUPPLIER", OperationCategory.SUPPLIER_RISK_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UNBLOCK_SUPPLIER", OperationCategory.SUPPLIER_RISK_MANAGEMENT),

                // Supplier Documents
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPLOAD_SUPPLIER_DOCUMENT", OperationCategory.SUPPLIER_DOCUMENT_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "VERIFY_SUPPLIER_DOCUMENT", OperationCategory.SUPPLIER_DOCUMENT_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "DOWNLOAD_SUPPLIER_DOCUMENT", OperationCategory.SUPPLIER_DOCUMENT_MANAGEMENT),

                // RFQ Operations
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_RFQ", OperationCategory.RFQ_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPDATE_RFQ", OperationCategory.RFQ_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "DELETE_RFQ", OperationCategory.RFQ_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "PUBLISH_RFQ", OperationCategory.RFQ_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CLOSE_RFQ", OperationCategory.RFQ_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "SUBMIT_RFQ_RESPONSE", OperationCategory.RFQ_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "EVALUATE_RFQ_RESPONSE", OperationCategory.RFQ_MANAGEMENT),

                // RFP Operations
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_RFP", OperationCategory.RFP_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPDATE_RFP", OperationCategory.RFP_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "PUBLISH_RFP", OperationCategory.RFP_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "SUBMIT_RFP_RESPONSE", OperationCategory.RFP_MANAGEMENT),

                // Contract Operations
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_CONTRACT", OperationCategory.CONTRACT_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPDATE_CONTRACT", OperationCategory.CONTRACT_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "APPROVE_CONTRACT", OperationCategory.CONTRACT_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "REJECT_CONTRACT", OperationCategory.CONTRACT_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "SIGN_CONTRACT", OperationCategory.CONTRACT_MANAGEMENT),

                // Purchase Requisition
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_PR", OperationCategory.PURCHASE_REQUISITION),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPDATE_PR", OperationCategory.PURCHASE_REQUISITION),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "APPROVE_PR", OperationCategory.PURCHASE_REQUISITION),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "REJECT_PR", OperationCategory.PURCHASE_REQUISITION),

                // Purchase Order
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_PO", OperationCategory.PURCHASE_ORDER),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPDATE_PO", OperationCategory.PURCHASE_ORDER),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "APPROVE_PO", OperationCategory.PURCHASE_ORDER),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "SEND_PO", OperationCategory.PURCHASE_ORDER),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CANCEL_PO", OperationCategory.PURCHASE_ORDER),

                // Invoice Operations
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_INVOICE", OperationCategory.INVOICE_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "SUBMIT_INVOICE", OperationCategory.INVOICE_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "APPROVE_INVOICE", OperationCategory.INVOICE_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "REJECT_INVOICE", OperationCategory.INVOICE_MANAGEMENT),

                // Payment Operations
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "PROCESS_PAYMENT", OperationCategory.PAYMENT_PROCESSING),

                // User Management
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_USER", OperationCategory.USER_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPDATE_USER", OperationCategory.USER_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "DELETE_USER", OperationCategory.USER_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "LOCK_USER", OperationCategory.USER_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UNLOCK_USER", OperationCategory.USER_MANAGEMENT),

                // Role Management
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "CREATE_ROLE", OperationCategory.ROLE_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "UPDATE_ROLE", OperationCategory.ROLE_MANAGEMENT),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "ASSIGN_ROLE", OperationCategory.ACCESS_CONTROL),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "REMOVE_ROLE", OperationCategory.ACCESS_CONTROL),

                // Reporting
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "VIEW_REPORTS", OperationCategory.REPORTING),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "EXPORT_REPORTS", OperationCategory.REPORTING),

                // System Operations
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "MANAGE_SYSTEM_CONFIGURATION", OperationCategory.SYSTEM_CONFIGURATION),
                new Operation(SystemUtility.generateIdForEntity(SystemConstant.OPERATION_ENTITY_NAME), "MANAGE_INTEGRATIONS", OperationCategory.INTEGRATION_MANAGEMENT)
        );

        for(Operation operation : operations){
            SystemUtility.setGlobalRecordsValue(operation);
        }

        return operations;
    }
}