package com.bank.antifraud.entity.card;

import com.bank.antifraud.entity.abstractclasses.SuspiciousTransfer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "suspicious_card_transfer", schema = "anti_fraud")
@Data
@NoArgsConstructor
public class SuspiciousCardTransfer extends SuspiciousTransfer {

    @Column(name = "card_transfer_id", unique = true, nullable = false)
    private int cardTransferId;

    public SuspiciousCardTransfer(int cardTransferId, boolean isBlocked, boolean isSuspicious, String blockedReason,
                                     String suspiciousReason) {
        super(isBlocked, isSuspicious, blockedReason, suspiciousReason);
        this.cardTransferId = cardTransferId;
    }
}
