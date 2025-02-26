package com.Capgemini.Employee.Payroll.Controller;

import com.Capgemini.Employee.Payroll.DTO.EmployeeDto;
import com.Capgemini.Employee.Payroll.Entity.Employee;
import com.Capgemini.Employee.Payroll.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    private EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeePayrollController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeePayrollController(){}

    @PostMapping("/post")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}