package pl.kompikownia.dziennik.dziennik.model;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Teacher {
    private Integer ID;
    private String name;
    private String surname;
    private String PESEL;
    private Set<Subject> schoolSubjects;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="teacherID", unique=true, nullable = false)
    public Integer getID() {
        return ID;
    }
    @Column(name="name",nullable = false,length=45)
    public String getName() {
        return name;
    }
    @Column(name="surname",nullable = false,length=45)
    public String getSurname() {
        return surname;
    }
    @Column(name="PESEL",nullable=false,length=11)
    public String getPESEL() {
        return PESEL;
    }
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(
            name="teacher_subject",
            joinColumns = {@JoinColumn(name="teacherID")},
            inverseJoinColumns = {@JoinColumn(name="subjectID")}
    )
    public Set<Subject> getSchoolSubjects() {
        return schoolSubjects;
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

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setSchoolSubjects(Set<Subject> schoolSubjects) {
        this.schoolSubjects = schoolSubjects;
    }


}
