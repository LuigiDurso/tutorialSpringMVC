package it.si2001.service;

import it.si2001.model.Skill;

import java.util.List;

public interface SkillService
{
    Skill findById(int id);

    Skill findByName(String name);

    List<Skill> findAllSkills();
}
