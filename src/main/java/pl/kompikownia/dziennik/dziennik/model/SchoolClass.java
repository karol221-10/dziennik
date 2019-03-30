package pl.kompikownia.dziennik.dziennik.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "class")
public class SchoolClass {
    private Integer classID;
    private String className;
    private Integer classNumber;
    private Integer educatorID;
    private Set<Student> students = new HashSet<>();
    public SchoolClass() {

    }
    public SchoolClass(String className,Integer classNumber) {
        this.className = className;
        this.classNumber = classNumber;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classID",unique = true,nullable = false)
    public Integer getClassID() {
        return classID;
    }
    @Column(name="className",nullable = false)
    public String getClassName() {
        return className;
    }
    @Column(name="classNumber",nullable=false)
    public Integer getClassNumber() {
        return classNumber;
    }
    @Column(name="educatorID")
    public Integer getEducatorID() {
        return educatorID;
    }
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(
            name="class_student",
            joinColumns = {@JoinColumn(name = "classID")},
            inverseJoinColumns = {@JoinColumn(name="studentID")}
    )
    public Set<Student> getStudents() {
        return students;
    }
    public void setClassID(Integer classID) {
        this.classID = classID;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public void setEducatorID(Integer educatorID) {
        this.educatorID = educatorID;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
