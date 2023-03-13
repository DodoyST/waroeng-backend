package com.niconoe.waroeng.controller;

import com.niconoe.waroeng.entity.Unit;
import com.niconoe.waroeng.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping(path = "/units")
    public List<Unit> getAllUnit() {
        return unitService.getAll();
    }

    @GetMapping(path = "/unit/{id}")
    public Unit getUnitById(@PathVariable(name = "id") String id) {
        return unitService.getById(id);
    }
}
