package com.keyin.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRestRepository employeeRestRepository;

    public Iterable<Employee> getAllEmployees(){
        return employeeRestRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        // Check for employee if they are already in DB
        Optional<Employee> employeeOptional = employeeRestRepository.findEmployeeByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
        return employeeOptional.orElseGet(() -> employeeRestRepository.save(employee));

    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRestRepository.findById(id);
    }
}
