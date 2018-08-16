package com.example.demo.repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/15.
 */
@Service
public class RepositoriesInitializer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Object lock=new Object();
    private boolean initialized=false;
    public void iniialize()
    {
        if(!initialized)
        {
            synchronized (lock)
            {
                if(!initialized)
                {
                    initializeAll();
                    initialized=true;
                }
            }
        }
    }
    private void initializeAll()
    {
        initializeUsers();
        initializeEmployees();
        initializeDepartments();

    }
    private void initializeUsers() {
        if (userRepository.count() > 0) return;
        User user;
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        user = new User(
                "user",
                bCryptPasswordEncoder.encode("pass"),
                roles,
                null);
        userRepository.save(user);
        roles.clear();
        roles.add("ADMIN");
        user = new User(
                "admin",
                bCryptPasswordEncoder.encode("pass"),
                roles,
                null);
        userRepository.save(user);
        roles.clear();
        roles.add("ACTUATOR");
        user = new User(
                "actuator",
                bCryptPasswordEncoder.encode("pass"),
                roles,
                null);
        userRepository.save(user);
    }

    private void initializeDepartments() {
        if(departmentRepository.count()>0)
            return;
        departmentRepository.save(new Department(null, "test-1", "test-1"));
        departmentRepository.save(new Department(null, "test-2", "test-2"));
        departmentRepository.save(new Department(null, "test-3", "test-3"));
    }

    private void initializeEmployees() {
        if(employeeRepository.count()>0)
            return;
        Department department = new Department(null, "test-4", "test-4");
        Employee manager = new Employee(null, "manager-1", "manager-1", null,
                System.currentTimeMillis(),
                0.0, 0.0, department);
        employeeRepository.save(new Employee(
                null, "employee-1", "employee-1", manager,
                System.currentTimeMillis(),
                0.0, 0.0, department));
    }
}
