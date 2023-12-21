//package com.bank.antifraud.aspect;
//
//import com.bank.antifraud.entity.SuspiciousAccountTransferAudit;
//import com.bank.antifraud.service.SuspiciousTransferAuditService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import java.sql.Timestamp;
//
//@Component
//@Aspect
//public class LoggingAspect {
//
//    private final SuspiciousTransferAuditService suspiciousTransferAuditService;
//    private final ObjectMapper objectMapper;
//
//    public LoggingAspect(SuspiciousTransferAuditService suspiciousTransferAuditService, ObjectMapper objectMapper) {
//        this.suspiciousTransferAuditService = suspiciousTransferAuditService;
//        this.objectMapper = objectMapper;
//    }
//
//    @Pointcut("execution(* com.bank.antifraud.controller.SuspiciousAccountTransferController.delete*(..))")
//    private void allAccountCrudMethods() {}
//
//    @Around("allAccountCrudMethods()")
//    public Object beforeSaveSuspiciousAccountTransfer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        Object targetMethodResult = proceedingJoinPoint.proceed();
//
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        String operationType = null;
//        if (methodName.contains("create")) {
//            operationType = "create";
//        } else if (methodName.contains("update")) {
//            operationType = "update";
//        } else if (methodName.contains("delete")) {
//            operationType = "delete";
//        }
//
//        SuspiciousAccountTransferAudit audit = null;
//        try {
//            audit = SuspiciousAccountTransferAudit.builder()
//                    .entityType(targetMethodResult.getClass().getSimpleName())
//                    .operationType(operationType)
//                    .createdBy("anti_fraud")
//                    .createdAt(new Timestamp(System.currentTimeMillis()))
//                    .modifiedBy(null)
//                    .modifiedAt(null)
//                    .newEntityJson(null)
//                    .entityJson(objectMapper.writeValueAsString(targetMethodResult))
//                    .build();
//            suspiciousTransferAuditService.createAudit(audit);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        return targetMethodResult;
//
//
//    }
//}
