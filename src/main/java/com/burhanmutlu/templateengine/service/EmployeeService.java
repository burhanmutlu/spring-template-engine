package com.burhanmutlu.templateengine.service;

import com.burhanmutlu.templateengine.dto.EmployeeDto;
import com.burhanmutlu.templateengine.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployee();
    void createEmployee(Employee employee);
    EmployeeDto getEmployeById(Long id);
    void deleteEmployeeById(Long id);

}
