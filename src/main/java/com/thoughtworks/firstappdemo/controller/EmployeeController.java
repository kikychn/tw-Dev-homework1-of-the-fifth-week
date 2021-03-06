package com.thoughtworks.firstappdemo.controller;

import com.thoughtworks.firstappdemo.domain.Employee;
import com.thoughtworks.firstappdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {

    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PostMapping("/employee/save")
    public Employee save(@RequestParam String name, int age, String gender) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setGender(gender);
        if (employeeRepo.save(employee)) {
            System.out.println("员工对象保存成功：" + employee.toString());
        }
        return employee;
    }

    @GetMapping("/employees")
    public Collection<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
}
