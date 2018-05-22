package it.si2001.dao;

import it.si2001.model.Skill;

import java.util.List;

public interface SkillDao
{
    Skill findById(int id);

    Skill findByName(String name);

    List<Skill> findAllSkills();
}
