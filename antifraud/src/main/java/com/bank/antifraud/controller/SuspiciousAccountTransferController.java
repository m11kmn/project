package com.bank.antifraud.controller;
import com.bank.antifraud.entity.account.SuspiciousAccountTransfer;
import com.bank.antifraud.handler.SuspiciousAccountTransferErrorResponse;
import com.bank.antifraud.exception.SuspiciousAccountTransferNotFoundException;
import com.bank.antifraud.service.SuspiciousAccountTransferService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class SuspiciousAccountTransferController {

    private final SuspiciousAccountTransferService suspiciousAccountTransferService;

    @Autowired
    public SuspiciousAccountTransferController(SuspiciousAccountTransferService suspiciousTransferService) {
        this.suspiciousAccountTransferService = suspiciousTransferService;
    }


    @PostMapping("/create")
    public SuspiciousAccountTransfer createSuspiciousAccountTransfer(@RequestBody SuspiciousAccountTransfer suspiciousAccountTransfer) {
        suspiciousAccountTransferService.create(suspiciousAccountTransfer);
        return suspiciousAccountTransfer;
    }

    @GetMapping("/read")
    public List<SuspiciousAccountTransfer> readAllSuspiciousAccountTransfers() {
        return suspiciousAccountTransferService.getAll();
    }

    @GetMapping("/read/{id}")
    public SuspiciousAccountTransfer readSuspiciousAccountTransfer(@PathVariable("id") int id) {
        return suspiciousAccountTransferService.get(id).orElse(null);
    }

    @PutMapping("/update")
    public SuspiciousAccountTransfer updateSuspiciousAccountTransfer(@RequestBody SuspiciousAccountTransfer suspiciousAccountTransfer) {
        suspiciousAccountTransferService.update( suspiciousAccountTransfer);
        return suspiciousAccountTransfer;
    }

    @DeleteMapping("/delete/{id}")
    public SuspiciousAccountTransfer deleteSuspiciousAccountTransfer(@PathVariable("id") int id) {
        SuspiciousAccountTransfer suspiciousAccountTransfer = suspiciousAccountTransferService.get(id).orElse(null);
        suspiciousAccountTransferService.delete(id);
        return suspiciousAccountTransfer;
    }

}
