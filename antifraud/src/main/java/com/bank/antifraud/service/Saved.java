//package com.bank.antifraud.service;
//import com.bank.antifraud.entity.account.AccountTransfer;
//import com.bank.antifraud.entity.account.SuspiciousAccountTransfer;
//import com.bank.antifraud.repository.AccountTransferRepository;
//import com.bank.antifraud.repository.SuspiciousAccountTransferRepository;
//import com.bank.antifraud.exception.SuspiciousAccountTransferNotFoundException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Service
//@Transactional(readOnly = true)
//public class SuspiciousAccountTransferService {
//
//    private final AccountTransferRepository accountTransferRepository;
//    private final SuspiciousAccountTransferRepository suspiciousAccountTransferRepository;
//
//    public SuspiciousAccountTransferService(AccountTransferRepository accountTransferRepository, SuspiciousAccountTransferRepository suspiciousAccountTransferRepository) {
//        this.accountTransferRepository = accountTransferRepository;
//        this.suspiciousAccountTransferRepository = suspiciousAccountTransferRepository;
//    }
//
//    //Поиск транзакции по номеру в таблице
//    public boolean hasFoundAccountTransfer(int number) {
//        return Optional.ofNullable(accountTransferRepository.findAccountTransfer(number)).isEmpty();
//    }
//
//    //Поиск подозрительной транзакции по id в таблице
//    public boolean hasFoundSuspiciousAccountTransfer(int id) {
//        return Optional.ofNullable(suspiciousAccountTransferRepository.findSuspiciousAccountTransfer(id)).isEmpty();
//    }
//
//    //Логика обработки транзакции
//    @Transactional
//    public SuspiciousAccountTransfer checkAccountTransfer(AccountTransfer accountTransfer) {
//        //Для анализа достаем интересующую нас информацию из AccountTransfer
//        int accountNumber = accountTransfer.getAccountNumber();
//        double amount = accountTransfer.getAmount();
//        String purpose = accountTransfer.getPurpose();
//
//        //Поля SuspiciousAccountTransfer по умолчанию
//        boolean isSuspicious = false;
//        boolean isBlocked = false;
//        String blockedReason = "Не заблокирован";
//        String suspiciousReason = "Подозрений нет";
//
//        //Логика обрабатывает 3 аспекта транзакции: сумма перевода, текст перевода и совершались ли ранее на этот номер переводы
//        if ((amount > 500000) && hasFoundAccountTransfer(accountNumber) || purpose.contains("Запрещенный текст")) {
//            isBlocked = true;
//            isSuspicious = true;
//            suspiciousReason = "Большая сумма перевода и на этот номер ранее не было переводов";
//            blockedReason = "Операция заблокирована из-за множества подозрений";
//            if (purpose.contains("Запрещенный текст")) {
//                suspiciousReason = "Запрещенный текст";
//                blockedReason = "Запрещенный текст";
//            }
//        } else if (amount > 500000){
//            isSuspicious = true;
//            suspiciousReason = "Большая сумма перевода";
//        } else if (hasFoundAccountTransfer(accountNumber)) {
//            isSuspicious = true;
//            suspiciousReason = "На этот номер ранее не было переводов";
//        }
//
//        //Если транзакция с таким номером уже есть в таблице, то беру ее id и присваиваю новой транзакции (чтобы метод .save() обновил строку, а не создал новую)
//        if (!hasFoundAccountTransfer(accountNumber)) {
//            int id = accountTransferRepository.findAccountTransfer(accountNumber).getId();
//            accountTransfer.setId(id);
//        }
//        accountTransferRepository.save(accountTransfer);
//
//        //Заполняю сущность SuspiciousAccountTransfer в соответствии с условием
//
//        int accountTransferId = accountTransferRepository.findAccountTransfer(accountNumber).getId();
//        SuspiciousAccountTransfer suspiciousAccountTransfer = new SuspiciousAccountTransfer(accountTransferId, isBlocked, isSuspicious, blockedReason, suspiciousReason);
//
//        //Аналогично примеру выше, чтобы .save() обновлял строку
//        if (!hasFoundSuspiciousAccountTransfer(accountTransferId)) {
//            int id = suspiciousAccountTransferRepository.findSuspiciousAccountTransfer(accountTransferId).getId();
//            suspiciousAccountTransfer.setId(id);
//        }
//        suspiciousAccountTransferRepository.save(suspiciousAccountTransfer);
//
//        return suspiciousAccountTransfer;
//    }
//
//    ////////////////////////////////////////////////////////////
//    ///___Все стандартные CRUD операции (не используются)___///
//    ///////////////////////////////////////////////////////////
//    @Transactional
//    public void createOrUpdateSuspiciousAccountTransfer(SuspiciousAccountTransfer suspiciousAccountTransfer) {
//
//        int accountTransferId = suspiciousAccountTransfer.getAccountTransferId();
//        if (!hasFoundSuspiciousAccountTransfer(accountTransferId)) {
//            int id = suspiciousAccountTransferRepository.findSuspiciousAccountTransfer(accountTransferId).getId();
//            suspiciousAccountTransfer.setId(id);
//        }
//
//        suspiciousAccountTransferRepository.save(suspiciousAccountTransfer);
//
//        log.info("Подозрительная транзакция с id - {} сохранена в базе данных",
//                suspiciousAccountTransferRepository.findSuspiciousAccountTransfer(accountTransferId).getId());
//    }
//
//    public List<SuspiciousAccountTransfer> readAllSuspiciousAccountTransfer() {
//        return suspiciousAccountTransferRepository.findAll();
//    }
//
//    public SuspiciousAccountTransfer readOneSuspiciousAccountTransfer(int id) {
//        Optional<SuspiciousAccountTransfer> suspiciousAccountTransfer = suspiciousAccountTransferRepository.findById(id);
//        return suspiciousAccountTransfer.orElseThrow(() -> new SuspiciousAccountTransferNotFoundException("There is no SuspiciousAccountTransfer with ID - " + id));
//    }
//
//    @Transactional
//    public void deleteSuspiciousAccountTransfer(int id) {
//        suspiciousAccountTransferRepository.deleteById(id);
//    }
//}
