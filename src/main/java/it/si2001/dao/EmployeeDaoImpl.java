package it.si2001.dao;

import it.si2001.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer,Employee> implements EmployeeDao
{
    public Employee findById(int id)
    {
        return getByKey(id);
    }

    public Employee findByUsername(String name)
    {
        try
        {
            Employee employee = (Employee) getEntityManager()
                    .createQuery("SELECT e FROM Employee e WHERE e.username LIKE :username")
                    .setParameter("username", name)
                    .getSingleResult();

            return employee;
        }catch(NoResultException ex)
        {
            return null;
        }
    }

    public void saveEmployee(Employee employee)
    {
        this.persist(employee);
    }

    public void deleteEmployeeById(int id)
    {
        Employee employee = (Employee) getEntityManager()
                .createQuery("SELECT e FROM Employee e WHERE e.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();
        delete(employee);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees()
    {
        return getEntityManager()
                .createQuery("SELECT e FROM Employee e")
                .getResultList();
    }
}
