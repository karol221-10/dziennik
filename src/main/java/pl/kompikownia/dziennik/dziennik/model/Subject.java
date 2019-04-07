package pl.kompikownia.dziennik.dziennik.model;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="subject")
public class Subject {
    private Integer ID;
    private String name;
    private Set<Teacher> learnedBy;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="subject",nullable = false, unique = true)
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
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLearnedBy(Set<Teacher> learnedBy) {
        this.learnedBy = learnedBy;
    }
}
