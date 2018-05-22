package it.si2001.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skill")
public class Skill
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSkills")
    private int id;
    @Column(name = "Skill")
    private String skill;

    public Skill()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
