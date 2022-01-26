package com.tsystems.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * Created by Mahesh on 24-01-2022.
 */
@Getter
@Setter
@Table(name = "T_SYS_PERSON")
@Entity
public class PersonEntity {

    @Id
    @Column(name = "person_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
