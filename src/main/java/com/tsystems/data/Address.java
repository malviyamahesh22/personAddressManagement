package com.tsystems.data;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Mahesh on 24-01-2022.
 */

@Getter
@Setter
public class Address {

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private Integer pincode;

    /*public Address(String address1, String address2, String city, String state, String country, Integer pincode) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }*/
}
