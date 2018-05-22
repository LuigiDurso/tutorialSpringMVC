package it.si2001.service;

import it.si2001.dao.SkillDao;
import it.si2001.model.Skill;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("SkillService")
@Transactional
public class SkillServiceImpl implements SkillService
{
    private final SkillDao dao;

    public SkillServiceImpl(SkillDao dao)
    {
        this.dao=dao;
    }

    public Skill findById(int id)
    {
        return dao.findById(id);
    }

    public Skill findByName(String name)
    {
        return dao.findByName(name);
    }

    public List<Skill> findAllSkills()
    {
        return dao.findAllSkills();
    }
}
