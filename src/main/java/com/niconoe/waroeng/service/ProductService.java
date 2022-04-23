package com.niconoe.waroeng.service;

import com.niconoe.waroeng.entity.Product;

public interface ProductService extends CrudService<Product> {
    Product scanBarcode(String barcode);
}
