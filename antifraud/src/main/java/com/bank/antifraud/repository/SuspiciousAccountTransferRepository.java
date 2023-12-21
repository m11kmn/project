package com.bank.antifraud.repository;

import com.bank.antifraud.entity.account.SuspiciousAccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspiciousAccountTransferRepository extends BaseRepository<SuspiciousAccountTransfer> {

//    @Query("from SuspiciousAccountTransfer a where a.accountTransferId = :accountTransferId")
//    public SuspiciousAccountTransfer findSuspiciousAccountTransfer(@Param("accountTransferId") int accountTransferId);
}
