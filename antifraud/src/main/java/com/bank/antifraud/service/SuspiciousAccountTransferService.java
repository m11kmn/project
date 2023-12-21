package com.bank.antifraud.service;

import com.bank.antifraud.entity.account.SuspiciousAccountTransfer;
import com.bank.antifraud.repository.BaseRepository;
import com.bank.antifraud.repository.SuspiciousAccountTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuspiciousAccountTransferService implements BaseService<SuspiciousAccountTransfer>{

    private final SuspiciousAccountTransferRepository suspiciousAccountTransferRepository;

    @Autowired
    public SuspiciousAccountTransferService(SuspiciousAccountTransferRepository suspiciousAccountTransferRepository) {
        this.suspiciousAccountTransferRepository = suspiciousAccountTransferRepository;
    }

    @Override
    public BaseRepository<SuspiciousAccountTransfer> getRepository() {
        return suspiciousAccountTransferRepository;
    }
}
