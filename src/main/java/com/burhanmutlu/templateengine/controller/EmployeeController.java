package com.burhanmutlu.templateengine.controller;

import com.burhanmutlu.templateengine.dto.EmployeeDto;
import com.burhanmutlu.templateengine.entity.Employee;
import com.burhanmutlu.templateengine.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

@Controller // restController rest api icin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Long id, Model model) {
        EmployeeDto employeeDto = employeeService.getEmployeById(id);
        model.addAttribute("employee", employeeDto);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }


}
