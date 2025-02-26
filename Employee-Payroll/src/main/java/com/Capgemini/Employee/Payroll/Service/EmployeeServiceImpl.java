package com.Capgemini.Employee.Payroll.Service;

import com.Capgemini.Employee.Payroll.DTO.EmployeeDto;
import com.Capgemini.Employee.Payroll.DTO.EmployeeDtoMapper;
import com.Capgemini.Employee.Payroll.Entity.Employee;
import com.Capgemini.Employee.Payroll.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(){}

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto addEmployee(Employee employee){
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.mapToEmployeeDto(savedEmployee);
    }

    public EmployeeDto getEmployee(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return EmployeeDtoMapper.mapToEmployeeDto(employee);
    }

    public EmployeeDto updateEmployee(Employee employee){
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeDtoMapper.mapToEmployeeDto(updatedEmployee);
    }

    public void  deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}