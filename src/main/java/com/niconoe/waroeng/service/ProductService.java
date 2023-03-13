package com.niconoe.waroeng.service;

import com.niconoe.waroeng.entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product create(Product product);

    Page<Product> getAll(Integer page, Integer size, String filter);

    Product getById(String id);

    Product update(Product product);

    Product deleteById(String id);

    Product scanBarcode(String barcode);
}
