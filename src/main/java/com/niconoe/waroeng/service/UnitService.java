package com.niconoe.waroeng.service;

import com.niconoe.waroeng.entity.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> getAll();

    Unit getById(String id);
}
