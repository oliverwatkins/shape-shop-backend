package com.shapeshop.service;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.CategoryRepository;
import com.shapeshop.repository.CompanyRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository catRep;

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


    public void deleteCategory(CategoryEntity categoryEntity, String companyName) {

//        CompanyEntity company = companyRep.findByName(companyName);
        CategoryEntity category= catRep.findByName(categoryEntity.getName());
        catRep.delete(category);


//        catRep


//        public void deleteProduct(long id) {
//            productRep.deleteById(id);
//        }
//
//        public void deleteProduct(ProductEntity p) {
//            productRep.delete(p);
//        }

//        if (company == null) {
//            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
//        }
////        categoryEntity.setCompany(company);
////        categoryEntity.setId(0);
//
//        categoryEntity = catRep.save(categoryEntity);
//        return categoryEntity;

    }



    public void updateCategory(ProductEntity product, Long id, String companyName) throws ShapeShopException {
        //TODO
    }

    public CategoryEntity getCategory(CategoryEntity categoryEntity, String companyName) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);
        if (company == null) {
            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
        }

        CategoryEntity c = catRep.findByName(categoryEntity.getName());

//        categoryEntity.setCompany(company);
//        categoryEntity.setId(0);
//
//        categoryEntity = catRep.save(categoryEntity);
        return categoryEntity;

    }

}
