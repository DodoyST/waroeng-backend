package com.niconoe.waroeng.controller;

import com.niconoe.waroeng.entity.Product;
import com.niconoe.waroeng.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping(path = "/products")
    public Page<Product> getAllProduct(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page, @RequestParam(name = "size", defaultValue = "5", required = false) Integer size, @RequestParam(name = "filter", defaultValue = "", required = false) String filter) {
        return productService.getAll(page, size, filter);
    }

    @GetMapping(path = "/product/{id}")
    public Product getProductById(@PathVariable(name = "id") String id) {
        return productService.getById(id);
    }

    @PutMapping(path = "/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping(path = "/product")
    public Product deleteProductById(@RequestParam(name = "id") String id) {
        return productService.deleteById(id);
    }

    @GetMapping(path = "/scan/{barcode}")
    public Product getByScanBarcode(@PathVariable(name = "barcode") String barcode) {
        return productService.scanBarcode(barcode);
    }
}