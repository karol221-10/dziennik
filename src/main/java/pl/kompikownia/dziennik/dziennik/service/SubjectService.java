package pl.kompikownia.dziennik.dziennik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kompikownia.dziennik.dziennik.model.Subject;
import pl.kompikownia.dziennik.dziennik.model.enums.ErrorTypes;
import pl.kompikownia.dziennik.dziennik.model.enums.SubjectLevel;
import pl.kompikownia.dziennik.dziennik.model.enums.SubjectType;
import pl.kompikownia.dziennik.dziennik.repository.SubjectRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {this.subjectRepository = subjectRepository;}

    public Set<Subject> getAllSubjects() {return subjectRepository.getAllSubjects();}

    public ErrorTypes addSubject(String name, SubjectLevel subjectLevel, SubjectType subjectType) {
        if(subjectRepository.getSpecificSubject(name,subjectLevel,subjectType)==null) {
            Subject subject = new Subject(name,subjectLevel,subjectType);
            entityManager.persist(subject);
            return ErrorTypes.OK;
        }
        else return ErrorTypes.SUBJECT_EXISTS;
    }
}
