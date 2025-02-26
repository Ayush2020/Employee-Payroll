package com.Capgemini.Employee.Payroll.DTO;


import com.Capgemini.Employee.Payroll.Entity.Employee;

public class EmployeeDtoMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(employee.getName(), employee.getSalary());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee =  new Employee();
        employee.setName(employeeDto.name());
        employee.setSalary(employeeDto.salary());
        return employee;
    }
}