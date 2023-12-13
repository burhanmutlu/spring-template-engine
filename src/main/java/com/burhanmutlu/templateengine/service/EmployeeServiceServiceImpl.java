package com.burhanmutlu.templateengine.service;

import com.burhanmutlu.templateengine.dao.EmployeeRepository;
import com.burhanmutlu.templateengine.dto.EmployeeDto;
import com.burhanmutlu.templateengine.entity.Employee;
import com.burhanmutlu.templateengine.exception.EmployeeNotFoundException;
import com.burhanmutlu.templateengine.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            employeeDtoList.add(employeeMapper.toEmployeeDto(employee));
        });

        return employeeDtoList;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto getEmployeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> {
            throw new EmployeeNotFoundException("employee not found"); });

        return employeeMapper.toEmployeeDto(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> {
            throw new EmployeeNotFoundException("employee not found"); });

        employeeRepository.deleteById(id);
    }
}
