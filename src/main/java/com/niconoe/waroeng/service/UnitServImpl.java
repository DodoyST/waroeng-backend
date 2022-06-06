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
    public Unit create(Unit unit) {
        unit.setName(unit.getName().toLowerCase());
        unit.setAbbreviation(unit.getAbbreviation().toUpperCase());
        existsValidation(unit);
        return unitRepository.save(unit);
    }

    @Override
    public List<Unit> getAll() {
        return unitRepository.findAll();
    }

    @Override
    public Unit getById(String id) {
        if (!unitRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Satuan tidak ditemukan");
        }
        return null;
    }

    @Override
    public Unit update(Unit unit) {
        getById(unit.getId());
        return unitRepository.save(unit);
    }

    @Override
    public Unit deleteById(String id) {
        Unit unit = getById(id);
        unitRepository.deleteById(id);
        return unit;
    }

    private void existsValidation(Unit unit) {
        if (unitRepository.existsByName(unit.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Nama %s sudah digunakan satuan lain", unit.getName()));
        }
        if (unitRepository.existsByAbbreviation(unit.getAbbreviation())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Singkatan %s sudah digunakan satuan lain", unit.getAbbreviation()));
        }
    }
}
