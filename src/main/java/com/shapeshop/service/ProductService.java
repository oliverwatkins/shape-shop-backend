package com.shapeshop.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.*;
import com.shapeshop.repository.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class ProductService {



    @Autowired
    EntityManager entitymanager;

    @Autowired
    ProductRepository productRep;

    @Autowired
    OrderRepository orderRep;

    @Autowired
    ProductCategoryRepository pcRep;

    @Autowired
    private CompanyRepository companyRep;

    @Autowired
    private CategoryRepository categoryRep;

//    public ProductEntity createProduct(ProductEntity product, String companyName, String category) throws ShapeShopException {
////        ProductCategoryEntity categoryEntity = categoryRep.findByName(category);
////        if (categoryEntity == null) {
////            throw new ShapeShopException("Category does not exist ", ShapeShopException.ErrorType.CATEGORY_DOES_NOT_EXIST);
////        }
//
//        CompanyEntity company = companyRep.findByName(companyName);
//        if (company == null) {
//            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
//        }
//        product.setCompany(company);
////        product.getCategories().add(categoryEntity);
//        product.setId(0);
//
//        product = productRep.save(product);
//        return product;
//    }



    public ProductEntity createProduct(ProductEntity product, String companyName, String categoryName) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);
        if (company == null) {
            throw new ShapeShopException("Company does not exist : " + companyName, ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
        }
        product.setCompany(company);
        product.setId(0);

        CategoryEntity cat = categoryRep.findByName(categoryName);
        if (cat == null) {
            throw new ShapeShopException("Category does not exist : " + categoryName, ShapeShopException.ErrorType.CATEGORY_DOES_NOT_EXIST);
        }

        ArrayList<ProductCategoryEntity> al = new ArrayList<>();
        al.add(new ProductCategoryEntity(cat));

        product.setProductCategories(al);

        product = productRep.save(product);

        return product;
    }

    /**
     * @deprecated can only create product with cat
     */
    public ProductEntity createProduct(ProductEntity product, String companyName) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);
        if (company == null) {
            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
        }
        product.setCompany(company);
        product.setId(0);

        product = productRep.save(product);
        return product;
    }

    public void updateProduct(ProductEntity product, Long id, String companyName) throws ShapeShopException {

        CompanyEntity company = companyRep.findByName(companyName);
        if (company == null) {
            throw new ShapeShopException("Company does not exist ", ShapeShopException.ErrorType.COMPANY_DOES_NOT_EXIST);
        }

        List<ProductEntity> prods = this.getProductsByCompany(company);
        ProductEntity foundEntity = null;

        for (ProductEntity p: prods) {
            if (p.getId() == id) {
                foundEntity = p;
            }
        }

        if (foundEntity != null) {
            if (product.getName() != null)
                foundEntity.setName(product.getName());
            if (product.getPrice() != null)
                foundEntity.setPrice(product.getPrice());
            productRep.save(foundEntity);
        }else {
            throw new ShapeShopException("Product does not exist ", ShapeShopException.ErrorType.PROD_NOT_FOUND);
        }
    }

    public List<ProductEntity> getProductsByCompany(CompanyEntity company) {
        Query productsByCompany = entitymanager.
                createQuery("Select p from ProductEntity p where p.company.name = :compName").setParameter("compName", company.getName());

        List<ProductEntity> products = productsByCompany.getResultList();

        return products;
    }

    public List<ProductEntity> getProductsByCompanyAndCategory(CompanyEntity c, CategoryEntity cat) {

        Query productsByCompany = entitymanager.
                createQuery("Select p from ProductEntity p where p.company.name = :compName").setParameter("compName", c.getName());

        List<ProductEntity> products = productsByCompany.getResultList();

        List<ProductEntity> products2 = new ArrayList<>();

//        List<ProductEntity> result = StreamSupport.stream(productRep.findByCompany(c).spliterator(), false)
//                .collect(Collectors.toList());

        CompanyEntity company = companyRep.findByName("carlscafe");

        for (ProductEntity product : products) {
            var asdf = product.getProductCategories().stream().filter(pc -> pc.getCategory().getId() == cat.getId()).collect(Collectors.toList());
            if (asdf.size() > 0)
                products2.add(product);
        }

        return products2;

////        double[] d = {8, 7, -6, 5, -4};
//        List<ProductEntity> p2 = products.stream().filter(p -> {
//            p.getProductCategories().stream().filter(
//                        x -> {
//                            x.getCategory().getId() == cat.getId());
//                            return true;
//                            }
//                    );
//            return true;
//        }).toArray();


//        for (ProductEntity productEntity : products) {
//
//
//            val orders = productEntity.getOrders();
//            System.out.println("orders.size() " + orders.size());
//
////            select b.fname, b.lname from Users b JOIN b.groups c where c.groupName = :groupName
//            Query query = entitymanager.
//                    createQuery("Select o from OrderEntity o JOIN o.orderItems oi where oi.product.id = :pid").setParameter("pid", productEntity.getId());
//
//            final var resultList = query.getResultList();
//        }
//
//        List<OrderEntity> orders = orderRep.findByCompany(company);
//        for (OrderEntity order : orders) {
//            System.out.println("order : " + order);
//
//        }
//        return products;
    }

    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> result = StreamSupport.stream(productRep.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return result;
    }

    public ProductEntity getProductById(long id) {
        return productRep.findById(id);
    }

    public void deleteProduct(long id) {
        productRep.deleteById(id);
    }

    public void deleteProduct(ProductEntity p) {
        productRep.delete(p);
    }



}
