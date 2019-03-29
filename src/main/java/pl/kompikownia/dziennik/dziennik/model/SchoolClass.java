package pl.kompikownia.dziennik.dziennik.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "class")
public class SchoolClass {
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
           name="class_student",
            joinColumns = {@JoinColumn(name = "classID")},
            inverseJoinColumns = {@JoinColumn(name="studentID")}
    )
    ArrayList<Student> students = new ArrayList<>();
    private Integer classID;
    private String className;
    private Integer classNumber;
    private Integer educatorID;

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

}
