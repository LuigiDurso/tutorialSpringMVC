package it.si2001.dao;

import it.si2001.model.Employee;

import java.util.List;

public interface EmployeeDao
{

    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(int id);

    List<Employee> findAllEmployees();

}