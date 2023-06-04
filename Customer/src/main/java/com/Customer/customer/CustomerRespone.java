package com.Customer.customer;
import com.Customer.common.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerRespone {
    private Integer id ;
    private String fullname;
    private String adress;
    private String phone;
    private String email;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String updateBy;
    private String createBy;
    private Status status;
}
