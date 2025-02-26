package com.Capgemini.Employee.Payroll.Service;


import com.Capgemini.Employee.Payroll.DTO.EmployeeDto;
import com.Capgemini.Employee.Payroll.Entity.Employee;

public interface EmployeeService {
    EmployeeDto addEmployee(Employee employee);
    EmployeeDto getEmployee(Long id);
    EmployeeDto updateEmployee(Employee employee);
    void  deleteEmployee(Long id);

}