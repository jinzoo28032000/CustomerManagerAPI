package com.Customer.controller;

import com.Customer.customer.CustomerRequest;
import com.Customer.customer.CustomerRespone;
import com.Customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/customer")
@Tag(name = "Customer API")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Operation(summary = "Lấy ra danh sách Customer đang Active có status = 0")
    @GetMapping(value = "findAll")
    public ResponseEntity<List<CustomerRespone>> getALl() {
        return ResponseEntity.ok().body(customerService.getAll());
    }

    @Operation(summary = "Lấy ra thông tin Customer theo Id")
    @GetMapping(value = "findById")
    public ResponseEntity<CustomerRespone> findById(@RequestParam Integer id) {
        return ResponseEntity.ok().body(customerService.findById(id));
    }

    @Operation(summary = "Thêm thông tin Customer")
    @PostMapping(value = "create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerRespone> create(@RequestBody CustomerRequest customerRequest) {
        System.out.println("1-----" + customerRequest);
        return ResponseEntity.ok().body(customerService.Create(customerRequest));
    }

    @Operation(summary = "Cập nhật thông tin Customer")
    @PostMapping(value = "update", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerRespone> update(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.ok().body(customerService.Update(customerRequest));
    }

    @Operation(summary = "Vô hiệu hoá Customer")
    @DeleteMapping(value = "delete")
    public ResponseEntity<CustomerRespone> delete(@RequestParam Integer id) {
        return ResponseEntity.ok().body(customerService.delete(id));
    }
}
