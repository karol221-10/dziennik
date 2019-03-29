package pl.kompikownia.dziennik.dziennik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kompikownia.dziennik.dziennik.model.SchoolClass;
import pl.kompikownia.dziennik.dziennik.model.Student;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface ClassRepository extends JpaRepository<SchoolClass,Long> {

    @Query("SELECT sch FROM SchoolClass sch")
    List<SchoolClass> getAllClasses();
    @Query("SELECT sch FROM SchoolClass sch WHERE sch.classID=?1")
    SchoolClass getClassByID(Integer id);
    @Query("SELECT s FROM SchoolClass sch JOIN sch.students s WHERE sch.classID = ?1")
    Set<Student> getStudentFromClass(Integer classID);
}
