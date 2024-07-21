package com.bitwire.rainbow.table.service;

public interface CrudServiceInterface<T> {
    T findById(Long id);

    T create(T t);

    T update(T t);

    void delete(Long id);
}
