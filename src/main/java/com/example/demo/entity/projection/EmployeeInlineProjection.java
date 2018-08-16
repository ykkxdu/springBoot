package com.example.demo.entity.projection;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by Administrator on 2018/8/16.
 */
@Projection(name = "inline",types = Employee.class)
public interface EmployeeInlineProjection {
    Long getId();
    String getEname();
    String getJob();
    Employee getMgr();
    Long getHiredate();
    Double getSal();
    Double getComm();
    Department getDepartment();
}
