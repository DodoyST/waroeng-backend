package com.niconoe.waroeng.controller;

import com.niconoe.waroeng.entity.ProductUnitMapping;
import com.niconoe.waroeng.service.ProductUnitMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProductUnitMappingController {
    @Autowired
    private ProductUnitMappingService productUnitMappingService;

    @PostMapping(path = "/productunitmapping")
    public ProductUnitMapping createProductUnitMapping(@RequestBody ProductUnitMapping productUnitMapping) {
        return productUnitMappingService.create(productUnitMapping);
    }

    @GetMapping(path = "/productunitmappings")
    public List<ProductUnitMapping> getAllProductUnitMapping() {
        return productUnitMappingService.getAll();
    }

    @GetMapping(path = "/productunitmapping/{id}")
    public ProductUnitMapping getProductUnitMappingById(@PathVariable(name = "id") String id) {
        return productUnitMappingService.getById(id);
    }

    @GetMapping(path = "/productunitmappings/{product_id}")
    public List<ProductUnitMapping> getAllProductUnitMappingByProduct(@PathVariable(name = "product_id") String product_id) {
        return productUnitMappingService.getAllByProduct(product_id);
    }

    @PutMapping(path = "/productunitmapping")
    public ProductUnitMapping updateProductUnitMapping(@RequestBody ProductUnitMapping productUnitMapping) {
        return productUnitMappingService.update(productUnitMapping);
    }

    @DeleteMapping(path = "/productunitmapping")
    public ProductUnitMapping deleteProductUnitMappingById(@RequestParam(name = "id") String id) {
        return productUnitMappingService.deleteById(id);
    }
}
