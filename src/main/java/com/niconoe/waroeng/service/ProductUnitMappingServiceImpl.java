package com.niconoe.waroeng.service;

import com.niconoe.waroeng.entity.Product;
import com.niconoe.waroeng.entity.ProductUnitMapping;
import com.niconoe.waroeng.repository.ProductUnitMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductUnitMappingServiceImpl implements ProductUnitMappingService {
    @Autowired
    private ProductUnitMappingRepository productUnitMappingRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UnitService unitService;

    @Override
    public ProductUnitMapping create(ProductUnitMapping productUnitMapping) {
        productUnitMapping.setProduct(productService.getById(productUnitMapping.getProductId()));
        productUnitMapping.setUnit(unitService.getById(productUnitMapping.getUnitId()));
        existValidation(productUnitMapping);
        return productUnitMappingRepository.save(productUnitMapping);
    }

    @Override
    public List<ProductUnitMapping> getAll() {
        return productUnitMappingRepository.findAll();
    }

    @Override
    public ProductUnitMapping getById(String id) {
        if (!productUnitMappingRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mapping tidak ditemukan");
        }
        return productUnitMappingRepository.findById(id).get();
    }

    @Override
    public List<ProductUnitMapping> getAllByProduct(String productId) {
        Product product = productService.getById(productId);
        return productUnitMappingRepository.findAllByProduct(product);
    }

    @Override
    public ProductUnitMapping update(ProductUnitMapping productUnitMapping) {
        productUnitMapping.setProduct(productService.getById(productUnitMapping.getProductId()));
        productUnitMapping.setUnit(unitService.getById(productUnitMapping.getUnitId()));
        getById(productUnitMapping.getId());
        return productUnitMappingRepository.save(productUnitMapping);
    }

    @Override
    public ProductUnitMapping deleteById(String id) {
        ProductUnitMapping productUnitMapping = getById(id);
        productUnitMappingRepository.deleteById(id);
        return productUnitMapping;
    }

    @Override
    @Transactional
    public void deleteByProduct(Product product) {
        productUnitMappingRepository.deleteByProduct(product);
    }

    private void existValidation(ProductUnitMapping productUnitMapping) {
        if (productUnitMappingRepository.existsByProductAndUnitAndQuantity(productUnitMapping.getProduct(), productUnitMapping.getUnit(), productUnitMapping.getQuantity())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Product %s dengan Unit %s dan dengan Quantity %s sudah didaftarkan", productUnitMapping.getProduct().getName(), productUnitMapping.getUnit().getName(), productUnitMapping.getQuantity()));
        }
    }


}
