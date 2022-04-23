package com.niconoe.waroeng.repository;

import com.niconoe.waroeng.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findProductByName(String name);

    Product getByBarcode(String barcode);

    boolean existsByName(String name);

    boolean existsByBarcode(String barcode);
}
