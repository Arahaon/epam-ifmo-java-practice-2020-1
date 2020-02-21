package com.ifmo.epampractice.service;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> addObject(T object);

    List<T> getAll();

    T getById(int id);

    void updateByObject(T object);

    void removeById(int id);
}
