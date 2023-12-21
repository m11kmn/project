//package com.bank.antifraud.service;
//
//import com.bank.antifraud.entity.SuspiciousAccountTransferAudit;
//import com.bank.antifraud.repository.SuspiciousAccountTransferAuditRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional(readOnly = true)
//public class SuspiciousTransferAuditService {
//    private final SuspiciousAccountTransferAuditRepository suspiciousAccountTransferAuditRepository;
//
//    @Autowired
//    public SuspiciousTransferAuditService(SuspiciousAccountTransferAuditRepository suspiciousAccountTransferAuditRepository) {
//        this.suspiciousAccountTransferAuditRepository = suspiciousAccountTransferAuditRepository;
//    }
//
//    @Transactional
//    public void createAudit(SuspiciousAccountTransferAudit audit) {
//        suspiciousAccountTransferAuditRepository.save(audit);
//    }
//
//    public List<SuspiciousAccountTransferAudit> readAllAudit() {
//        return suspiciousAccountTransferAuditRepository.findAll();
//    }
//}
