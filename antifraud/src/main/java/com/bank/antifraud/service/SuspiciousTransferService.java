//package com.bank.antifraud.service;
//
//import com.bank.antifraud.entity.abstractclasses.SuspiciousTransfer;
//import com.bank.antifraud.entity.account.AccountTransfer;
//import com.bank.antifraud.entity.account.SuspiciousAccountTransfer;
//import com.bank.antifraud.exception.SuspiciousAccountTransferNotFoundException;
//import com.bank.antifraud.repository.SuspiciousAccountTransferRepository;
//import com.bank.antifraud.repository.SuspiciousTransferRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class SuspiciousTransferService<T extends SuspiciousAccountTransfer>{
//
//    private final SuspiciousTransferRepository<SuspiciousAccountTransfer> suspiciousTransferRepository;
//
//    //    private final SuspiciousAccountTransferRepository suspiciousPhoneTransferRepository;
//    //    private final SuspiciousAccountTransferRepository suspiciousCardTransferRepository;
//
//    public SuspiciousTransferService(SuspiciousAccountTransferRepository suspiciousTransferRepository) {
//        this.suspiciousTransferRepository = suspiciousTransferRepository;
//    }
//
//    ////////////////////////////////////////////////////////////
//    ///___Все стандартные CRUD операции (не используются)___///
//    ///////////////////////////////////////////////////////////
//
//    Optional<T> create(T t) {
//        if (suspiciousTransferRepository.existsById(t.getId())) {
//            return Optional.of(suspiciousTransferRepository.save(t));
//        }
//        return Optional.empty();
//    }
//
//    public List<T> readAll() {
//        return suspiciousTransferRepository.findAll();
//    }
//
//    public T read(int id) {
//        Optional<T> suspiciousTransfer = suspiciousTransferRepository.findById(id);
//        return suspiciousTransfer.orElseThrow(() -> new SuspiciousAccountTransferNotFoundException("There is no SuspiciousAccountTransfer with ID - " + id));
//    }
//
//    Optional<T> update(T t) {
//        if (suspiciousTransferRepository.existsById(t.getId())) {
//            return Optional.of(suspiciousTransferRepository.save(t));
//        }
//        return Optional.empty();
//    }
//
//    public void delete(int id) {
//        suspiciousTransferRepository.deleteById(id);
//    }
//}
