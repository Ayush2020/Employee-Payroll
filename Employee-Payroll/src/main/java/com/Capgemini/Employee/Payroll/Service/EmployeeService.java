package com.Capgemini.Employee.Payroll.Service;

import com.Capgemini.Employee.Payroll.DTO.EmployeeDTO;
import com.Capgemini.Employee.Payroll.Entity.Employee;
import com.Capgemini.Employee.Payroll.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    public EmployeeService() {
        // Adding some dummy employees
        employeeList.add(new Employee(1, "Ayush Giri", 50000));
        employeeList.add(new Employee(2, "John Doe", 60000));
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Add a new employee
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

}
