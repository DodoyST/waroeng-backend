package com.niconoe.waroeng.service;

import java.util.List;

public interface CrudService<T> {
    T create(T t);

    List<T> getAll();

    T getById(String id);

    T update(T t);

    T deleteById(String id);
}
