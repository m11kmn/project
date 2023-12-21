package com.bank.antifraud.entity.account;

import com.bank.antifraud.entity.abstractclasses.SuspiciousTransfer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "suspicious_account_transfers", schema = "anti_fraud")
@Data
@NoArgsConstructor
public class SuspiciousAccountTransfer extends SuspiciousTransfer {

    @Column(name = "account_transfer_id", unique = true, nullable = false)
    private int accountTransferId;

    public SuspiciousAccountTransfer(int accountTransferId, boolean isBlocked, boolean isSuspicious, String blockedReason,
                                     String suspiciousReason) {
        super(isBlocked, isSuspicious, blockedReason, suspiciousReason);
        this.accountTransferId = accountTransferId;
    }
}
