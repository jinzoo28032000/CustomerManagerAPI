package com.Customer.entities;
import com.Customer.entities.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "customer")
@Data
public class Customer extends BaseEntity {

    @Column(length = 255)
    private String password;

    @Column(length = 255)
    private String fullname;

    @Column(length = 255)
    private String adress;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String email;


}
