package pl.kompikownia.dziennik.dziennik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kompikownia.dziennik.dziennik.model.Teacher;
import pl.kompikownia.dziennik.dziennik.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class TeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {this.teacherRepository = teacherRepository;}

    public Set<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }
}
