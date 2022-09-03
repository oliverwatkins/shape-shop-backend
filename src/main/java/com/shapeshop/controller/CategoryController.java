package com.shapeshop.controller;

import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.repository.CategoryRepository;
import com.shapeshop.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

