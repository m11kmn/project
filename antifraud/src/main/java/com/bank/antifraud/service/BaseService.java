package com.bank.antifraud.service;

import com.bank.antifraud.entity.account.SuspiciousAccountTransfer;
import com.bank.antifraud.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends SuspiciousAccountTransfer> {

    BaseRepository<T> getRepository();

    default T create(T t) {
        return getRepository().save(t);
    }

    default Optional<T> update(T t) {
        if (getRepository().existsById(t.getId())) {
            return Optional.of(getRepository().save(t));
        }
        return Optional.empty();
    }

    default Optional<T> get(int id) {
        return getRepository().findById(id);
    }

    default List<T> getAll() {
        return getRepository().findAll();
    }

    default void delete(int id) {
        getRepository().deleteById(id);
    }

}
