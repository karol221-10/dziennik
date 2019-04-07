package pl.kompikownia.dziennik.dziennik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kompikownia.dziennik.dziennik.model.Subject;
import pl.kompikownia.dziennik.dziennik.repository.SubjectRepository;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {this.subjectRepository = subjectRepository;}

    public Set<Subject> getAllSubjects() {return subjectRepository.getAllSubjects();}
}
