package com.shapeshop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductEntity createProduct(ProductEntity product) {
        productRepository.save(product);
        return product;
    }

    public List<ProductEntity> getProductsByCompany(CompanyEntity company) {
        List<ProductEntity> result = StreamSupport.stream(productRepository.findByCompany(company).spliterator(), false)
                .collect(Collectors.toList());
        return result;
    }

    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> result = StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return result;
    }

    public ProductEntity getProductById(long id) {
        return productRepository.findById(id);
    }

    public void updateProduct(ProductEntity product, Long id) {

        Optional<ProductEntity> pe = productRepository.findById(id);
//
        if (pe.isPresent()) {
            ProductEntity e = pe.get();

            e.setName(product.getName());
            e.setPrice(product.getPrice());
//
//            //merge e and product

            productRepository.save(e);
        } else {
            throw new RuntimeException("Cannot find product with id : " + id);
        }
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public void deleteProduct(ProductEntity p) {
        productRepository.delete(p);
    }
}
