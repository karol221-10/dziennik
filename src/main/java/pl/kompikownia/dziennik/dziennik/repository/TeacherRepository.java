package pl.kompikownia.dziennik.dziennik.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kompikownia.dziennik.dziennik.model.Teacher;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query("SELECT tec FROM Teacher tec")
    Set<Teacher> getAllTeachers();
}
