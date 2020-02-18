package com.ifmo.epampractice.service;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {

    void add(T object) throws SQLException;

    List<T> getAll() throws SQLException;

    T getById(int id) throws SQLException;

    void update(T object) throws SQLException;

    void removeByObject(T object) throws SQLException;

    void removeById(int id) throws SQLException;


}
