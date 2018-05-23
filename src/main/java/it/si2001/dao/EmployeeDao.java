package it.si2001.dao;

import it.si2001.model.Employee;

import java.util.List;

public interface EmployeeDao
{

    Employee findById(int id);

    Employee findByUsername(String name);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(int id);

    List<Employee> findAllEmployees();

}