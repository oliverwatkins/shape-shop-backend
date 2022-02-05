package com.shapeshop.controller;

import java.util.List;

import com.shapeshop.ErrorUtil;
import com.shapeshop.ShapeShopException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CompanyRepository companyR;

    @CrossOrigin
    @GetMapping(value = "/test")
    public String test() {
        return "hello";
    }


    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{companyName}/products")
    public ResponseEntity<?> newProduct(@RequestBody ProductEntity product,
                                        @PathVariable("companyName") String companyName) {
        ProductEntity s = null;
        try {
            s = productService.createProduct(product, companyName);
        } catch (ShapeShopException e) {
            e.printStackTrace();
            return new ResponseEntity<>("internal server error 2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{companyName}/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductEntity product,
                                           @PathVariable("id") Long id,
                                           @PathVariable("companyName") String companyName)  {
        try {
            productService.updateProduct(product, id, companyName);
        } catch (ShapeShopException e) {
            e.printStackTrace();

            ResponseEntity response = ErrorUtil.getResponseEntity(e);
            return response;

        } catch (Throwable t) {
            t.printStackTrace();
            return new ResponseEntity<>("internal server error 2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @CrossOrigin
    @GetMapping(value = "/{companyName}/products")
    public ProductEntity[] getProducts(@PathVariable("companyName") String companyName) {

        CompanyEntity c = companyR.findByName(companyName);
        List<ProductEntity> itemList = productService.getProductsByCompany(c);

        return itemList.toArray(new ProductEntity[itemList.size()]); //huh??
    }

    @GetMapping(value = "/{companyName}/products/{id}")
    public ProductEntity getProductsById(@PathVariable("companyName") String companyName, @PathVariable("id") long id) {
        ProductEntity item = productService.getProductById(id);
        return item;
    }

    @DeleteMapping(value = "/{companyName}/products/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteProductById(@PathVariable("id") long id) {
        productService.deleteProduct(id);
    }
}

