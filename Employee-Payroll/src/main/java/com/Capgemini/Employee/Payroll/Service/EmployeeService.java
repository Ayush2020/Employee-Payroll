package com.Capgemini.Employee.Payroll.Service;

import com.Capgemini.Employee.Payroll.Entity.Employee;
import com.Capgemini.Employee.Payroll.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updatedEmployee.getName());
                    existing.setGender(updatedEmployee.getGender());
                    existing.setDepartment(updatedEmployee.getDepartment());
                    existing.setSalary(updatedEmployee.getSalary());
                    return repository.save(existing);
                })
                .orElse(null);
    }


    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
