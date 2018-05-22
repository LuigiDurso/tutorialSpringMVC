package it.si2001.dao;

import it.si2001.model.MaritalStatus;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MaritalStatusDao")
public class MaritalStatusDaoImpl extends AbstractDao<Integer,MaritalStatus> implements MaritalStatusDao
{
    public MaritalStatus findById(int id)
    {
        return this.getByKey(id);
    }

    public MaritalStatus findByName(String name)
    {
        Criteria criteria=this.createEntityCriteria();
        criteria.add(Restrictions.eq("statoCivile",name));
        return (MaritalStatus) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<MaritalStatus> findAllStatus()
    {
        Criteria criteria=this.createEntityCriteria();
        return (List<MaritalStatus>) criteria.list();
    }
}
