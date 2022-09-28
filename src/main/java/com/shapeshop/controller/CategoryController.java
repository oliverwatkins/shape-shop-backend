package com.shapeshop.controller;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.ProductCategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.dto.CategoryDto;
import com.shapeshop.entity.dto.Converter;
import com.shapeshop.entity.dto.ProductDto;
import com.shapeshop.repository.CategoryRepository;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CompanyRepository companyR;

    @Autowired
    private CategoryRepository catR;

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{companyName}/categories")
    public ResponseEntity<?> newCategory(@RequestBody CategoryEntity categoryEntity,
                                        @PathVariable("companyName") String companyName) {
        CategoryEntity category;
        try {
            category = categoryService.createCategory(categoryEntity, companyName);
        } catch (ShapeShopException e) {
            e.printStackTrace();
            return new ResponseEntity<>("internal server error 2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{companyName}/categories")
    public ResponseEntity<?> deleteCategory(@RequestBody CategoryEntity categoryEntity,
                                         @PathVariable("companyName") String companyName
                                            ) {
//        CategoryEntity category;
        categoryService.deleteCategory(categoryEntity, companyName);

        return new ResponseEntity<>(categoryEntity, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{companyName}/categories")
    public List<CategoryDto> getCategories(@PathVariable("companyName") String companyName) {

        CompanyEntity c = companyR.findByName(companyName);

        List<CategoryEntity> itemList = catR.findByCompany(c);

        return Converter.convertCategoryToDto(itemList);

//        return itemList.toArray(new CategoryEntity[itemList.size()]);
    }
}

