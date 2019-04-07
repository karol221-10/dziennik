package pl.kompikownia.dziennik.dziennik.model;

import pl.kompikownia.dziennik.dziennik.model.enums.SubjectLevel;
import pl.kompikownia.dziennik.dziennik.model.enums.SubjectType;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="subject",
       uniqueConstraints=
        @UniqueConstraint(columnNames={"name","level","type"}))
public class Subject {
    private Integer ID;
    private String name;
    private Set<Teacher> learnedBy;
    private SubjectLevel level;
    private SubjectType type;

    public Subject() {}
    public Subject(String name, SubjectLevel level, SubjectType type) {
        this.name = name;
        this.level = level;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="subjectID",nullable = false, unique = true)
    public Integer getID() {
        return ID;
    }
    @Column(name="name",nullable = false)
    public String getName() {
        return name;
    }
    @ManyToMany(mappedBy = "schoolSubjects")
    public Set<Teacher> getLearnedBy() {
        return learnedBy;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="level")
    public SubjectLevel getLevel() {
        return level;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="type")
    public SubjectType getType() {
        return type;
    }


    public void setID(Integer ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLearnedBy(Set<Teacher> learnedBy) {
        this.learnedBy = learnedBy;
    }
    public void setLevel(SubjectLevel subjectLevel) {
        this.level = subjectLevel;
    }
    public void setType(SubjectType subjectType) {
        this.type = subjectType;
    }

}
