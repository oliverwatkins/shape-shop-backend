package com.shapeshop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.shapeshop.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRep;

    @Autowired
    private CompanyRepository companyRep;

    public ProductEntity createProduct(ProductEntity product) {
        productRep.save(product);
        return product;
    }

    public List<ProductEntity> getProductsByCompany(CompanyEntity company) {
        List<ProductEntity> result = StreamSupport.stream(productRep.findByCompany(company).spliterator(), false)
                .collect(Collectors.toList());
        return result;
    }

    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> result = StreamSupport.stream(productRep.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return result;
    }

    public ProductEntity getProductById(long id) {
        return productRep.findById(id);
    }

    public void updateProduct(ProductEntity product, Long id, String companyName) {

        CompanyEntity c = companyRep.findByName(companyName);

        List<ProductEntity> prods = this.getProductsByCompany(c);
        ProductEntity foundEntity = null;


        for (ProductEntity p: prods) {
            if (p.getId() == id) {
                foundEntity = p;
            }
        }

        if (foundEntity != null) {
            if (product.getName() != null)
                foundEntity.setName(product.getName());
            if (product.getPrice() != null)
                foundEntity.setPrice(product.getPrice());
            productRep.save(foundEntity);
        }else {
            throw new RuntimeException("Cannot find product with id " + id + " and company name " + companyName);
        }



//        Optional<ProductEntity> pe = productRep.findById(id);
//        if (pe.isPresent()) {
//            ProductEntity e = pe.get();
//
//            if (product.getName() != null)
//                e.setName(product.getName());
//            if (product.getPrice() != null)
//                e.setPrice(product.getPrice());
//
//
//
//
////            //merge e and product
//
//            productRep.save(e);
//        } else {
//            throw new RuntimeException("Cannot find product with id : " + id);
//        }
    }

    public void deleteProduct(long id) {
        productRep.deleteById(id);
    }

    public void deleteProduct(ProductEntity p) {
        productRep.delete(p);
    }
}
