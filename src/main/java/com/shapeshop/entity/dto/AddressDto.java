package com.shapeshop.entity.dto;

public class AddressDto {

    public String email;
    public String street;
    public String name;
    public String telephone;
    public String postcode;

    public AddressDto(String email, String street, String name, String telephone, String postcode) {
        this.email = email;
        this.street = street;
        this.name = name;
        this.telephone = telephone;
        this.postcode = postcode;
    }
}
