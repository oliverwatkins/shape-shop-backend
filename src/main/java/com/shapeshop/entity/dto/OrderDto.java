package com.shapeshop.entity.dto;

import com.shapeshop.entity.DeliveryType;
import com.shapeshop.entity.OrderState;
import com.shapeshop.entity.PaymentType;

import java.util.Date;
import java.util.List;

public class OrderDto {
    public long id;
    public Date date;
    public PaymentType paymentType;
    public DeliveryType deliveryType;
    public OrderState orderState;
    public AddressDto address;
    public CreditCardDto creditCard;
    public List<OrderItemDto> orderItems;
    public CompanyDto company;


    public OrderDto(long id, Date date, OrderState orderState, PaymentType paymentType, DeliveryType deliveryType, AddressDto address, CreditCardDto creditCard, List<OrderItemDto> orderItems, CompanyDto company) {
        this.id = id;
        this.date = date;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
        this.orderState = orderState;
        this.address = address;
        this.creditCard = creditCard;
        this.orderItems = orderItems;
        this.company = company;
    }
}
