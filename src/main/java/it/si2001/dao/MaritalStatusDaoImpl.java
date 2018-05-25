package it.si2001.dao;

import it.si2001.model.MaritalStatus;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
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
        try
        {
            MaritalStatus maritalStatus = (MaritalStatus) getEntityManager()
                    .createQuery("SELECT m FROM MaritalStatus m WHERE m.statoCivile LIKE :statoCivile")
                    .setParameter("statoCivile", name)
                    .getSingleResult();

            return maritalStatus;

        }
        catch(NoResultException ex)
        {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<MaritalStatus> findAllStatus()
    {
        return getEntityManager()
                .createQuery("SELECT m FROM MaritalStatus m")
                .getResultList();
    }
}
