package pl.kompikownia.dziennik.dziennik.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="student")
public class Student {
    private Integer ID;
    private String Name;
    private String Surname;
    private Date bornDate;
    @ManyToMany(mappedBy = "students")
    private ArrayList<SchoolClass> classes = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="studentID",unique = true,nullable = false)
    public Integer getID() {
        return ID;
    }
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return Name;
    }
    @Column(name="surname",nullable=false, length=45)
    public String getSurname() {
        return Surname;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="bornDate",nullable = false)
    public Date getBornDate() {
        return bornDate;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }
}
