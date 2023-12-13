package com.burhanmutlu.templateengine.mapper;

import com.burhanmutlu.templateengine.dto.EmployeeDto;
import com.burhanmutlu.templateengine.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEmployee(EmployeeDto employeeDto) {
        return Employee.builder()
                .name(employeeDto.getName())
                .email(employeeDto.getEmail())
                .id(employeeDto.getId())
                .build();
    }

    public EmployeeDto toEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .id(employee.getId())
                .build();
    }

}
