package com.bank.antifraud.repository;

import com.bank.antifraud.entity.abstractclasses.SuspiciousTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends SuspiciousTransfer> extends JpaRepository<T, Integer> {

}