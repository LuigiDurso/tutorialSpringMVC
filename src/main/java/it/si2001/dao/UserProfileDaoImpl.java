package it.si2001.dao;

import it.si2001.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao
{

    public UserProfile findById(int id)
    {
        return getByKey(id);
    }

    public UserProfile findByType(String type)
    {
        try
        {
            UserProfile userProfile = (UserProfile) getEntityManager()
                    .createQuery("SELECT u FROM UserProfile u WHERE u.type LIKE :type")
                    .setParameter("type", type)
                    .getSingleResult();

            return userProfile;

        }
        catch(NoResultException ex)
        {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll()
    {
        return getEntityManager()
                .createQuery("SELECT u FROM UserProfile u")
                .getResultList();
    }

}