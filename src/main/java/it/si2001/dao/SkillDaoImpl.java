package it.si2001.dao;

import it.si2001.model.Skill;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("SkillDao")
public class SkillDaoImpl extends AbstractDao<Integer,Skill> implements SkillDao
{
    public Skill findById(int id)
    {
        return this.getByKey(id);
    }

    public Skill findByName(String name)
    {
        try
        {
            Skill skill = (Skill) getEntityManager()
                    .createQuery("SELECT s FROM Skill s WHERE s.skill LIKE :skill")
                    .setParameter("skill", name)
                    .getSingleResult();

            return skill;

        }
        catch(NoResultException ex)
        {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Skill> findAllSkills()
    {
        return getEntityManager()
                .createQuery("SELECT s FROM Skill s")
                .getResultList();
    }
}
