package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/8/15.
 */
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
