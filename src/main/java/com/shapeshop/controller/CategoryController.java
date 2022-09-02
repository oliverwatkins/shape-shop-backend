package com.shapeshop.controller;

import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.CategoryRepository;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CompanyRepository companyR;

    @Autowired
    private CategoryRepository catR;

    @CrossOrigin
    @GetMapping(value = "/{companyName}/categories")
    public CategoryEntity[] getCategories(@PathVariable("companyName") String companyName) {

        CompanyEntity c = companyR.findByName(companyName);

        List<CategoryEntity> itemList = catR.findByCompany(c);

        return itemList.toArray(new CategoryEntity[itemList.size()]);
    }
}

