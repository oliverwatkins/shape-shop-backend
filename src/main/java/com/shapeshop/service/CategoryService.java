package com.shapeshop.service;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.ProductCategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.CategoryRepository;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.repository.ProductCategoryRepository;
import com.shapeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class CategoryService {

    @Autowired
    EntityManager entitymanager;

    @Autowired
    CategoryRepository catRep;

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


    public void deleteCategory(CategoryEntity categoryEntity, String companyName) {

        CategoryEntity category= catRep.findByName(categoryEntity.getName());

//        CompanyEntity company = companyRep.findByName(companyName);
        entitymanager.
                createQuery("Delete from ProductCategoryEntity p where p.category = :catid").setParameter("catid", categoryEntity);


        catRep.delete(category);


        System.out.println("");

//        prodCatRep.findByProduct()
//        prodCatRep.findByCat()

//        CompanyEntity company= companyRep.findByName(companyName);

//        prodRep2.find

//        List<ProductEntity> ps = prodRep.findByCompanyAndCategory(company, category);
//
////        for (ProductEntity p : ps) {
////            p.setCategory(null);
//////            prodRep.saveAndFlush(p);
////            prodRep.save(p);
////        }
//
//        List<ProductEntity> ps2 = prodRep.findByCompanyAndCategory(company, category);
//
//        for (ProductEntity p : ps2) {
//            System.out.println("p " + p);
////            p.setCategory(null);
////            prodRep.save(p);
//        }

//        CategoryEntity category2= catRep.findByName(categoryEntity.getName());
    }



    public void updateCategory(ProductEntity product, Long id, String companyName) throws ShapeShopException {
        //TODO
    }

    public ProductCategoryEntity getCategory(ProductCategoryEntity categoryEntity, String companyName) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);
        if (company == null) {
            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
        }



//        ProductCategoryEntity c = catRep.findByName(categoryEntity.getName());

//        categoryEntity.setCompany(company);
//        categoryEntity.setId(0);
//
//        categoryEntity = catRep.save(categoryEntity);
        return categoryEntity;

    }

}
