package com.niconoe.waroeng.service;

import com.niconoe.waroeng.entity.Unit;
import com.niconoe.waroeng.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UnitServImpl implements UnitService {
    @Autowired
    private UnitRepository unitRepository;


    @Override
    public List<Unit> getAll() {
        return unitRepository.findAll();
    }

    @Override
    public Unit getById(String id) {
        if (!unitRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Satuan tidak ditemukan");
        }
        return unitRepository.findById(id).get();
    }
}
