package it.si2001.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Model che rappresenta degli impiegati
 */
@Entity
@Table (name = "employee")
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemployee")
    private int id;
    @NotEmpty
    @Column(name="username", unique=true, nullable=false)
    private String username;
    @NotEmpty
    @Column(name="password", nullable=false)
    private String password;
    @NotEmpty
    @Column(name = "Name")
    private String name;
    @NotEmpty
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Country")
    private String country;
    @NotEmpty
    @Column(name = "BirthDate")
    private String birthDate;
    @ManyToOne()
    @JoinColumn(name="MaritalStatus", nullable=false)
    private MaritalStatus maritalStatus;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Employee_Skills",
            joinColumns = { @JoinColumn(name = "idemployee") },
            inverseJoinColumns = { @JoinColumn(name = "idSkills") }
    )
    private List<Skill> skills;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_profile_joinTable",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_profile_id") })
    private List<UserProfile> userProfiles;

    public Employee()
    {

    }

    public Employee(String name, String surname, String country)
    {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
