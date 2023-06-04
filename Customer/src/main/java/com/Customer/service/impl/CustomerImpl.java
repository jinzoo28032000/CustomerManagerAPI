package com.Customer.service.impl;

import com.Customer.common.Enum.Status;
import com.Customer.common.mapperUtil.ObjectMapperUtils;
import com.Customer.customer.CustomerRequest;
import com.Customer.customer.CustomerRespone;
import com.Customer.entities.Customer;
import com.Customer.repository.CustomerRepository;
import com.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<CustomerRespone> getAll() {
        List<CustomerRespone> listAll = customerRepository.findAll().stream()
                .filter(e -> e.getStatus().equals(Status.ACTIVE))
                .map(customer -> ObjectMapperUtils.map(customer, CustomerRespone.class))
                .collect(Collectors.toList());
        return listAll;
    }

    @Override
    public CustomerRespone Create(CustomerRequest request) {
        request.setId(null);
        Customer entity = ObjectMapperUtils.map(request, Customer.class);
        entity.setCreateBy("Nguyễn Cao Phước");
        entity.setCreateTime(Timestamp.from(Instant.now()));
        entity.setStatus(Status.ACTIVE);
        entity = customerRepository.save(entity);
        CustomerRespone respone = ObjectMapperUtils.map(entity, CustomerRespone.class);
        return respone;
    }
    public Boolean checkIb(Integer id) {
        if (id == 0 || id == null) {
            return false;
        }
        if (!customerRepository.existsById(id)) { // check id db
            return false;
        }
        return true;
    }
    @Override
    public CustomerRespone Update(CustomerRequest request) {
        if (!checkIb(request.getId())) {
            return null;
        }
        Customer eDb = customerRepository.findById(request.getId()).get();
        Customer e = ObjectMapperUtils.map(request, Customer.class);
        e.setUpdateBy(e.getUpdateBy());
        e.setUpdateTime(Timestamp.from(Instant.now()));
        e.setCreateBy(eDb.getCreateBy());
        e.setCreateTime(eDb.getCreateTime());
        return ObjectMapperUtils.map(customerRepository.save(e), CustomerRespone.class);
    }

    @Override
    public CustomerRespone delete(Integer id) {
        if (!checkIb(id)) {
            return null;
        }
        Customer e = customerRepository.findById(id).get();
        e.setStatus(Status.INACTIVE);
        e = customerRepository.save(e);
        return ObjectMapperUtils.map(e, CustomerRespone.class);
    }

    @Override
    public CustomerRespone findById(Integer id) {
        if (!checkIb(id)) {
            return null;
        }
        return ObjectMapperUtils.map(customerRepository.findById(id).get(), CustomerRespone.class);
    }
}
