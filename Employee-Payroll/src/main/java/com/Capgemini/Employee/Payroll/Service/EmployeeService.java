package com.Capgemini.Employee.Payroll.Service;

import com.Capgemini.Employee.Payroll.DTO.EmployeeDTO;
import com.Capgemini.Employee.Payroll.Entity.Employee;
import com.Capgemini.Employee.Payroll.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()))
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee emp = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return new EmployeeDTO(emp.getName(), emp.getSalary());
    }
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        Employee saveEmployee = repository.save(employee);
        return new EmployeeDTO(saveEmployee.getName(), saveEmployee.getSalary());
    }

    public Employee updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO) {
        Employee existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setName(updatedEmployeeDTO.getName());
        existing.setSalary(updatedEmployeeDTO.getSalary());
        return repository.save(existing);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }


}
