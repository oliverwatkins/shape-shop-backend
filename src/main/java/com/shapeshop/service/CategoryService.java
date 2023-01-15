package com.shapeshop.service;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.ProductCategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.dto.CategoryDto;
import com.shapeshop.entity.dto.Converter;
import com.shapeshop.repository.CategoryRepository;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.repository.ProductCategoryRepository;
import com.shapeshop.repository.ProductRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CategoryService {

    @Autowired
    EntityManager entitymanager;

    @Autowired
    CategoryRepository catRep;

    @Autowired
    ProductCategoryRepository prodCatRep;


    @Autowired
    ProductRepository prodRep;

    @Autowired
    private CompanyRepository companyRep;

    public CategoryEntity createCategory(CategoryEntity categoryEntity, String companyName) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);
        if (company == null) {
            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
        }
        categoryEntity.setCompany(company);
        categoryEntity.setId(0);

        categoryEntity = catRep.save(categoryEntity);
        return categoryEntity;
    }


    /**
     * TODO : Not working at the moemnt :
     *
     * could not execute statement; SQL [n/a]; constraint ["FK5N0VG2QTTW3G7ODMC3TIAL2N4: PUBLIC.PRODUCT_CATEGORY FOREIGN KEY(ID) REFERENCES PUBLIC.PRODUCT(ID) (12)"; SQL statement:
     * update product_category set id=null where id=? [23506-193]]
     *
     * @param categoryEntity
     * @param companyName
     */
    public void deleteCategory(CategoryEntity categoryEntity, String companyName) {

        CategoryEntity category= catRep.findByName(categoryEntity.getName());

        prodCatRep.deleteAll(category.getProductCategory());

        catRep.delete(category);
    }

    public CategoryEntity updateCategory(CategoryEntity categoryEntity, String companyName, Long id) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);

        List<CategoryEntity> categoryEntities = catRep.findByCompany(company);

        val foundEntity = categoryEntities.stream().filter(e -> e.getId() == id).findFirst();

        if (foundEntity.isPresent()) {
            foundEntity.get().setName(categoryEntity.getName());
            return catRep.save(foundEntity.get());
        }else {
            throw new ShapeShopException("Category does not exist " + categoryEntity.getName(), ShapeShopException.ErrorType.PROD_NOT_FOUND);
        }
    }

    public ProductCategoryEntity getCategory(ProductCategoryEntity categoryEntity, String companyName) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);
        if (company == null) {
            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
        }
        return categoryEntity;
    }
}
