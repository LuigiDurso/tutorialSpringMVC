package it.si2001.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "maritalstatus")
public class MaritalStatus implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMaritalStatus")
    private Integer id;
    @Column(name = "StatoCivile")
    private String statoCivile;
    @OneToMany(mappedBy="maritalStatus")
    private List<Employee> employees;

    public MaritalStatus()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MaritalStatus(String statoCivile)
    {
        this.statoCivile = statoCivile;
    }

    public String getStatoCivile() {
        return statoCivile;
    }

    public void setStatoCivile(String statoCivile) {
        this.statoCivile = statoCivile;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaritalStatus that = (MaritalStatus) o;
        return this.statoCivile.equals(((MaritalStatus) o).getStatoCivile());
    }
}
