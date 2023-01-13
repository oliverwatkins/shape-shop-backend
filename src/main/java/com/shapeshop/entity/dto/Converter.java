package com.shapeshop.entity.dto;

import com.shapeshop.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Converter {

    //TODO factory pattern etc.
    public static List<ProductDto> convertProductToDto(List<ProductEntity> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (ProductEntity product : products) {
            productDtos.add(convertProductToDto(product));
        }
        return productDtos;
    }

    public static ProductDto convertProductToDto(ProductEntity entity) {

        List<ProductCategoryEntity> productCategories =  entity.getProductCategories();
        List<CategoryEntity> cats = productCategories.stream().map(x->x.getCategory()).collect(Collectors.toList());

        List<CategoryDto> categoryDtos = convertCategoryToDto(cats);

        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getDescription(),
                entity.getImageFilename(),
                categoryDtos);
    }

    public static List<CategoryDto> convertCategoryToDto(List<CategoryEntity> categoryEntities) {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {

            try {
                categoryDtos.add(new CategoryDto(categoryEntity.getId(), categoryEntity.getName()));
            }catch(Exception e) {
                e.printStackTrace();
                throw e;
            }

        }
        return categoryDtos;
    }

    public static CategoryEntity convertCategoryDtoToEntity(CategoryDto cd) {
        CategoryEntity ce = new CategoryEntity(cd.getName());
        ce.setId(cd.getId());
        return ce;
    }

    public static List<OrderDto> convertOrderToDto(List<OrderEntity> orderEntities) {
        List<OrderDto> orders = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities) {

            AddressDto add = Converter.convertAddressToDto(orderEntity.getAddressEntity());
            CreditCardDto cc = Converter.convertCreditCardToDto(orderEntity.getCreditCardEntity());
            List<OrderItemDto> oi = Converter.convertOrderItemsToDto(orderEntity.getOrderItems());
            CompanyDto company = Converter.convertCompanyToDto(orderEntity.getCompany());

            OrderDto od = new OrderDto(orderEntity.getId(), orderEntity.getDate(), orderEntity.getState(), orderEntity.getPaymentType(), orderEntity.getDeliveryType(), add, cc, oi, company);

            orders.add(od);
        }
        return orders;
    }

    private static CompanyDto convertCompanyToDto(CompanyEntity company) {
        return new CompanyDto(company.getId(), company.getName());
    }

    private static List<OrderItemDto> convertOrderItemsToDto(List<OrderItemEntity> orderItems) {
        List<OrderItemDto> l = new ArrayList<>();
        for (OrderItemEntity entity : orderItems) {
            l.add(convertOrderItemToDto(entity));
        }
        return l;
    }

    private static OrderItemDto convertOrderItemToDto(OrderItemEntity orderItem) {
        return new OrderItemDto(convertProductToDto(orderItem.getProduct()), orderItem.getAmount());
    }

    private static CreditCardDto convertCreditCardToDto(CreditCardEntity creditCardEntity) {

        if (creditCardEntity!=null) {

            CreditCardDto od = new CreditCardDto(creditCardEntity.getNumber(),
                    creditCardEntity.getName(),
                    creditCardEntity.getId(),
                    creditCardEntity.getType(),
                    creditCardEntity.getExpDate());
            return od;
        }
        return null;
    }

    private static AddressDto convertAddressToDto(AddressEntity addressEntity) {
        if (addressEntity!=null) {
            AddressDto a = new AddressDto(addressEntity.getEmail(),
                    addressEntity.getStreet(),
                    addressEntity.getName(),
                    addressEntity.getTelephone(),
                    addressEntity.getPostcode());
            return a;
        }
        return null;
    }

    public static ProductEntity convertProductDtoToEntity(ProductDto product) {

        if (product !=null) {
            ProductEntity a = new ProductEntity(
                    product.name, product.price, "todo", product.description
            );
            return a;
        }
        return null;

    }
}
