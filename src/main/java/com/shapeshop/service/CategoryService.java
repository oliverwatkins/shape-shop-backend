package com.shapeshop.service;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.CategoryRepository;
import com.shapeshop.repository.CompanyRepository;
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

    public void updateCategory(ProductEntity product, Long id, String companyName) throws ShapeShopException {
        //TODO
    }
}
