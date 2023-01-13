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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

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

        List<CategoryEntity> categoryList = catRep.findByCompany(company);
        CategoryEntity foundEntity = null;

        for (CategoryEntity ce: categoryList) {
            if (ce.getId() == id) {
                foundEntity = ce;
            }
        }

        if (foundEntity != null) {
            foundEntity.setName(categoryEntity.getName());
            categoryEntity = catRep.save(foundEntity);
        }else {
            throw new ShapeShopException("Category does not exist " + categoryEntity.getName(), ShapeShopException.ErrorType.PROD_NOT_FOUND);
        }
//        Converter.convertCategoryToDto();

        return categoryEntity;
    }

    public ProductCategoryEntity getCategory(ProductCategoryEntity categoryEntity, String companyName) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);
        if (company == null) {
            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
        }
        return categoryEntity;
    }
}
