package it.si2001.dao;

import it.si2001.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer,Employee> implements EmployeeDao
{
    public Employee findById(int id)
    {
        return getByKey(id);
    }

    public void saveEmployee(Employee employee)
    {
        this.persist(employee);
    }

    public void deleteEmployeeById(int id)
    {
        Query query = getSession().createSQLQuery("delete from Employee where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees()
    {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Employee>) criteria.list();
    }
}
