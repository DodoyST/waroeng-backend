package com.niconoe.waroeng.service;

import com.niconoe.waroeng.entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService extends CrudService<Product> {
    Product scanBarcode(String barcode);

    Page<Product> getAllPageable(Integer page, Integer size, String filter);
}
