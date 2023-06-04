package com.Customer.service;

import com.Customer.customer.CustomerRequest;
import com.Customer.customer.CustomerRespone;

import java.util.List;

public interface CustomerService {
    List<CustomerRespone> getAll();
    CustomerRespone Create(CustomerRequest request);
    CustomerRespone Update(CustomerRequest request);
    CustomerRespone delete(Integer id);
    CustomerRespone findById(Integer id);
}
