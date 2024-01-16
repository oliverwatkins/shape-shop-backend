package com.shapeshop.controller;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.dto.CategoryDto;
import com.shapeshop.entity.dto.Converter;
import com.shapeshop.repository.CategoryRepository;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CompanyRepository companyR;

    @Autowired
    private CategoryRepository catR;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{companyName}/categories")
    public ResponseEntity<?> newCategory(@RequestBody CategoryDto categoryEntity,
                                        @PathVariable("companyName") String companyName) {
        CategoryDto category;
        try {
            CategoryEntity ce = categoryService.createCategory(Converter.convertCategoryDtoToEntity(categoryEntity), companyName);
            category = Converter.convertCategoryEntityToDto(ce);
        } catch (ShapeShopException e) {
            e.printStackTrace();
            return new ResponseEntity<>("internal server error 2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{companyName}/categories/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDto cDto,
                                         @PathVariable("id") Long id,
                                         @PathVariable("companyName") String companyName) {

        CategoryEntity category = Converter.convertCategoryDtoToEntity(cDto);
        try {
            category = categoryService.updateCategory(category, companyName, id);
        } catch (ShapeShopException e) {
            e.printStackTrace();
            return new ResponseEntity<>("internal server error 2", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //...ugh
        var al = new ArrayList<CategoryEntity>();
        al.add(category);
        return new ResponseEntity<>(Converter.convertCategoryListToDtoList(al), HttpStatus.OK);
    }



//
//    //    @CrossOrigin
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @DeleteMapping("/{companyName}/products/{id}")
//    public ResponseEntity<?> deleteProduct(
//            @PathVariable("id") Long id,
//            @PathVariable("companyName") String companyName) {
//
//
//



//    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{companyName}/categories/{id}")
    public ResponseEntity<?> deleteCategory(
                                            @PathVariable("id") String id,
                                            @PathVariable("companyName") String companyName)  {
        try {
            categoryService.deleteCategory(new Long(id), companyName);
        } catch (ShapeShopException e) {
            e.printStackTrace();
            return new ResponseEntity<>("delete category error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @CrossOrigin
    @GetMapping(value = "/{companyName}/categories")
    public List<CategoryDto> getCategories(@PathVariable("companyName") String companyName) {

        CompanyEntity c = companyR.findByName(companyName);

        List<CategoryEntity> itemList = catR.findByCompany(c);

        return Converter.convertCategoryListToDtoList(itemList);
    }
}

