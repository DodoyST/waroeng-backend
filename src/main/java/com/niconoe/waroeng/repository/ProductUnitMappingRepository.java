package com.niconoe.waroeng.repository;

import com.niconoe.waroeng.entity.Product;
import com.niconoe.waroeng.entity.ProductUnitMapping;
import com.niconoe.waroeng.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUnitMappingRepository extends JpaRepository<ProductUnitMapping, String> {
    List<ProductUnitMapping> findAllByProduct(Product product);

    boolean existsByProductAndUnitAndQuantity(Product product, Unit unit, Integer quantity);

    void deleteByProduct(Product product);
}
