package com.shapeshop.entity.dto;

import com.shapeshop.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Converter {

    //TODO factory pattern etc.
    public static List<ProductDto> convertProductToDto(List<ProductEntity> itemList) {
        List<ProductDto> l = new ArrayList<>();
        for (ProductEntity entity : itemList) {
            l.add(convertProductToDto(entity));
        }
        return l;
    }

    public static ProductDto convertProductToDto(ProductEntity entity) {

        List<ProductCategoryEntity> c =  entity.getProductCategories();
        List<CategoryEntity> cats =c.stream().map(x->x.getCategory()).collect(Collectors.toList());

        List<CategoryDto> cats2 =convertCategoryToDto(cats);

//        List<CategoryEntity> cats =
        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getDescription(),
                entity.getImageFilename(),
                cats2);
    }

    public static List<CategoryDto> convertCategoryToDto(List<CategoryEntity> itemList) {
        List<CategoryDto> l = new ArrayList<>();
        for (CategoryEntity entity : itemList) {
            l.add(new CategoryDto(entity.getId(), entity.getName()));
        }
        return l;
    }
//    "date": 1639619535992,
//            "paymentType": "CARD",
//            "deliveryType": "DELIVERY",
//            "company": {"name": "carlscafe", "id": 1},
//            "id": 1,
//            "state": "OPEN",


    public static List<OrderDto> convertOrderToDto(List<OrderEntity> itemList) {
        List<OrderDto> l = new ArrayList<>();
        for (OrderEntity entity : itemList) {

//            entity.getAddressEntity()
            AddressDto add = Converter.convertAddressToDto(entity.getAddressEntity());
            CreditCardDto cc = Converter.convertCreditCardToDto(entity.getCreditCardEntity());
            List<OrderItemDto> oi = Converter.convertOrderItemsToDto(entity.getOrderItems());
            CompanyDto company = Converter.convertCompanyToDto(entity.getCompany());


//            entity.getCreditCardEntity();
//            entity.getOrderItems();
//            OrderDto od2 = new OrderDto(
            OrderDto od = new OrderDto(entity.getId(), entity.getDate(), entity.getState(), entity.getPaymentType(), entity.getDeliveryType(), add, cc, oi, company);

            l.add(od);
        }
        return l;
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
}
