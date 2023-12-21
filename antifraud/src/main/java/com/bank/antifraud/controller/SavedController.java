//package com.bank.antifraud.controller;
//import com.bank.antifraud.entity.SuspiciousAccountTransferAudit;
//import com.bank.antifraud.entity.account.AccountTransfer;
//import com.bank.antifraud.entity.account.SuspiciousAccountTransfer;
//import com.bank.antifraud.service.SuspiciousTransferAuditService;
//import com.bank.antifraud.handler.SuspiciousAccountTransferErrorResponse;
//import com.bank.antifraud.exception.SuspiciousAccountTransferNotFoundException;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@Tag(name = "Транзакция по номеру аккаунта", description = "Управляет CRUD операциями над сущностью SuspiciousAccountTransfer")
//@RequestMapping()
//public class SuspiciousAccountTransferController {
//
//    private final SuspiciousTransferService suspiciousTransferService;
//    private final SuspiciousTransferAuditService suspiciousTransferAuditService;
//
//    @Autowired
//    public SuspiciousAccountTransferController(SuspiciousTransferService suspiciousTransferService, SuspiciousTransferAuditService suspiciousTransferAuditService) {
//        this.suspiciousTransferService = suspiciousTransferService;
//        this.suspiciousTransferAuditService = suspiciousTransferAuditService;
//    }
//
//    @Operation(summary = "Обработка транзакции",
//            description = "Принимает транзакцию, далее прогоняет ее через логику поиска подозрительных действий " +
//                    "и сохраняет информацию о ней в базу данных")
//    @ApiResponse(responseCode = "200", description = "Successful create",
//            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SuspiciousAccountTransfer.class))})
//    @PostMapping("/transfer")
//    public SuspiciousAccountTransfer createTransfer(@RequestBody @Parameter(description = "Транзакция для обработки") AccountTransfer accountTransfer) {
//        return suspiciousTransferService.checkAccountTransfer(accountTransfer);
//    }
//
//    @Operation(summary = "Отправляет аудит")
//    @ApiResponse(responseCode = "200", description = "Successful post",
//            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SuspiciousAccountTransferAudit.class))})
//    @PostMapping("/audit")
//    public List<SuspiciousAccountTransferAudit> readAudit() {
//        return suspiciousTransferAuditService.readAllAudit();
//    }
//
//    ////////////////////////////////////////////////////////////
//    ///___Все стандартные CRUD операции (не используются)___///
//    ///////////////////////////////////////////////////////////
//
//    @Operation(summary = "Добавить информацию о новой транзакции")
//    @ApiResponse(responseCode = "200", description = "Successful create",
//            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SuspiciousAccountTransfer.class))})
//    @PostMapping("/create")
//    public SuspiciousAccountTransfer createSuspiciousAccountTransfer(@RequestBody @Parameter(description = "Новая подозрительная транзакция") SuspiciousAccountTransfer suspiciousAccountTransfer) {
//        suspiciousTransferService.createOrUpdateSuspiciousAccountTransfer(suspiciousAccountTransfer);
//        return suspiciousAccountTransfer;
//    }
//
//    @ApiResponse(responseCode = "200", description = "Successful read",
//            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SuspiciousAccountTransfer.class))})
//    @GetMapping("/read")
//    @Operation(summary = "Получить информацию обо всех транзакциях")
//    public List<SuspiciousAccountTransfer> readAllSuspiciousAccountTransfers() {
//        return suspiciousTransferService.readAllSuspiciousAccountTransfer();
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successful read",
//                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SuspiciousAccountTransfer.class))}),
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    @GetMapping("/read/{id}")
//    @Operation(summary = "Получить информацию о транзакции по ее id")
//    public SuspiciousAccountTransfer readSuspiciousAccountTransfer(@PathVariable("id") @Parameter(description = "Идентификатор пользователя") int id) {
//        return suspiciousTransferService.readOneSuspiciousAccountTransfer(id);
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successful update",
//                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SuspiciousAccountTransfer.class))}),
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    @PutMapping("/update/{id}")
//    @Operation(summary = "Обновить информацию о транзакции по ее id")
//    public SuspiciousAccountTransfer updateSuspiciousAccountTransfer(@RequestBody @Parameter(description = "Обновленная подозрительная транзакция") SuspiciousAccountTransfer suspiciousAccountTransfer) {
//        suspiciousTransferService.createOrUpdateSuspiciousAccountTransfer(suspiciousAccountTransfer);
//        return suspiciousAccountTransfer;
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Successful delete",
//                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = SuspiciousAccountTransfer.class))}),
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    @DeleteMapping("/delete/{id}")
//    @Operation(summary = "Удалить информацию о транзакции по ее id")
//    public SuspiciousAccountTransfer deleteSuspiciousAccountTransfer(@PathVariable("id") @Parameter(description = "Идентификатор пользователя") int id) {
//        SuspiciousAccountTransfer suspiciousAccountTransfer = suspiciousTransferService.readOneSuspiciousAccountTransfer(id);
//        suspiciousTransferService.deleteSuspiciousAccountTransfer(id);
//        return suspiciousAccountTransfer;
//    }
//
//    //Метод, который в себя ловит исключения и возвращает необходимый json
//    @ExceptionHandler
//    private ResponseEntity<SuspiciousAccountTransferErrorResponse> handleException(SuspiciousAccountTransferNotFoundException e) {
//        SuspiciousAccountTransferErrorResponse response = new SuspiciousAccountTransferErrorResponse(
//                System.currentTimeMillis()
//        );
//        response.setMessage(e.getMessage());
//
//        //В HTTP ответе будут тело объекта (response) и статус ошибки
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }
//}
