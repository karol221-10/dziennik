package pl.kompikownia.dziennik.dziennik.model;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="student")
public class Student {
    private Integer ID;
    private String name;
    private String surname;
    private Date bornDate;
    private Set<SchoolClass> classes = new HashSet<>();
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="studentID",unique = true,nullable = false)
    public Integer getID() {
        return ID;
    }
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return name;
    }
    @Column(name="surname",nullable=false, length=45)
    public String getSurname() {
        return surname;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="bornDate",nullable = false)
    public Date getBornDate() {
        return bornDate;
    }
    @ManyToMany(mappedBy = "students")
    public Set<SchoolClass> getClasses() {
        return classes;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }
    public void setClasses(Set<SchoolClass> classes) {
        this.classes = classes;
    }
}
