package com.niconoe.waroeng.service;

import com.niconoe.waroeng.entity.Product;
import com.niconoe.waroeng.entity.ProductUnitMapping;

import java.util.List;

public interface ProductUnitMappingService {
    ProductUnitMapping create(ProductUnitMapping productUnitMapping);

    List<ProductUnitMapping> getAll();

    ProductUnitMapping getById(String id);

    List<ProductUnitMapping> getAllByProduct(String productId);

    ProductUnitMapping update(ProductUnitMapping productUnitMapping);

    ProductUnitMapping deleteById(String id);

    void deleteByProduct(Product product);
}
