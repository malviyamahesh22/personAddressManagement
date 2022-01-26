package com.tsystems.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Mahesh on 24-01-2022.
 */
@Getter
@Setter
@Table(name = "T_SYS_ADDRESS")
@Entity
public class AddressEntity {

    @Id
    @Column(name = "person_id")
    private Integer id;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pincode")
    private Integer pincode;

}
