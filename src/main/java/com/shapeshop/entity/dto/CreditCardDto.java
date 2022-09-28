package com.shapeshop.entity.dto;

public class CreditCardDto {

    public String number;
    public String name;
    public long id;
    public String type;
    public String expDate;

    public CreditCardDto(String number, String name, long id, String type, String expDate) {
        this.number = number;
        this.name = name;
        this.id = id;
        this.type = type;
        this.expDate = expDate;
    }
}
