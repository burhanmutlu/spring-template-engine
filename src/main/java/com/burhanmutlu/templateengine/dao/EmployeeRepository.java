package com.burhanmutlu.templateengine.dao;

import com.burhanmutlu.templateengine.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
