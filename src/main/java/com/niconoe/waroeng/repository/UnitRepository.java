package com.niconoe.waroeng.repository;

import com.niconoe.waroeng.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, String> {
    boolean existsByName(String name);

    boolean existsByAbbreviation(String abbreviation);
}
