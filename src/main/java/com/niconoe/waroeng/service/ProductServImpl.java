package com.niconoe.waroeng.service;

import com.niconoe.waroeng.entity.Product;
import com.niconoe.waroeng.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        existValidation(product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(String id) {
        if (!productRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product dengan id %s tidak ditemukan", id));
        }
        return productRepository.getById(id);
    }

    @Override
    public Product update(Product product) {
        getById(product.getId());
        return productRepository.save(product);
    }

    @Override
    public Product deleteById(String id) {
        Product product = getById(id);
        productRepository.deleteById(id);
        return product;
    }

    @Override
    public Product scanBarcode(String barcode) {
        if (!productRepository.existsByBarcode(barcode)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product tidak ditemukan");
        }
        return productRepository.getByBarcode(barcode);
    }

    private void existValidation(Product product) {
        if (productRepository.existsByName(product.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Nama %s sudah digunakan product lain", product.getName()));
        }
        if (productRepository.existsByName(product.getBarcode())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Barcode tersebut telah digunakan product lain");
        }
    }
}
