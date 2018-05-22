package it.si2001.service;


import it.si2001.model.Employee;

import java.util.List;

public interface EmployeeService
{
    Employee findById(int id);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);

    List<Employee> findAllEmployees();

}
