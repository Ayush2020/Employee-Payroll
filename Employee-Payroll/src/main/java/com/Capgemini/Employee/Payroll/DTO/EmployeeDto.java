package com.Capgemini.Employee.Payroll.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDto{
    private String name;
    private double salary;
}