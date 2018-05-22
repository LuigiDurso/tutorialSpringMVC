package it.si2001.service;

import it.si2001.dao.EmployeeDaoImpl;
import it.si2001.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeServiceImpl implements EmployeeService
{

    private final EmployeeDaoImpl dao;

    public EmployeServiceImpl(EmployeeDaoImpl dao)
    {
        this.dao = dao;
    }

    public Employee findById(int id)
    {
        return dao.findById(id);
    }

    public void saveEmployee(Employee employee)
    {
        dao.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee)
    {
        Employee emp=dao.findById(employee.getId());

        if(emp!=null)
        {
            emp.setName(employee.getName());
            emp.setSurname(employee.getSurname());
            emp.setCountry(employee.getCountry());
        }
    }

    public void deleteEmployeeById(int id)
    {
        dao.deleteEmployeeById(id);
    }

    public List<Employee> findAllEmployees()
    {
        return dao.findAllEmployees();
    }
}
