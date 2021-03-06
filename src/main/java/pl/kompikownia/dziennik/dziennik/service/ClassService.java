package pl.kompikownia.dziennik.dziennik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kompikownia.dziennik.dziennik.model.SchoolClass;
import pl.kompikownia.dziennik.dziennik.repository.ClassRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClassService {
    private ClassRepository classRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public ClassService(ClassRepository classRepository) {this.classRepository=classRepository;}

    public void addClass(String className,Integer classNumber) {
        SchoolClass sch = new SchoolClass(className,classNumber);
        entityManager.persist(sch);
    }
    public void updateClass(Integer ID,String name,Integer number) {
        SchoolClass sch = classRepository.getClassByID(ID);
        sch.setClassName(name);
        sch.setClassNumber(number);
        entityManager.merge(sch);
    }
    public void deleteClassByID(Integer ID) {
        SchoolClass classToRemove = classRepository.getClassByID(ID);
        entityManager.remove(classToRemove);
    }
    public SchoolClass getClassByID(Integer ID) {
        return classRepository.getClassByID(ID);
    }
    public List<SchoolClass> getAllClasses() {
        return classRepository.getAllClasses();
    }
}
