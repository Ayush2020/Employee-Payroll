package com.Capgemini.Employee.Payroll.Repository;


import com.Capgemini.Employee.Payroll.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}