package it.si2001.dao;

import it.si2001.model.Skill;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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
        Criteria criteria=this.createEntityCriteria();
        criteria.add(Restrictions.eq("skill",name));
        return (Skill) criteria.uniqueResult();
    }

    public List<Skill> findAllSkills()
    {
        Criteria criteria=this.createEntityCriteria();
        return (List<Skill>) criteria.list();
    }
}
