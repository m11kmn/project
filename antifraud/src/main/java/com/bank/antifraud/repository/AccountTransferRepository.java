//package com.bank.antifraud.repository;
//
//import com.bank.antifraud.entity.account.AccountTransfer;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Integer> {
//
//    @Query("from AccountTransfer a where a.accountNumber = :accountNumber")
//    public AccountTransfer findAccountTransfer(@Param("accountNumber") int accountNumber);
//
//}