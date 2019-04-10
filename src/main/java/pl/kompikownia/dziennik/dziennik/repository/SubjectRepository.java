package pl.kompikownia.dziennik.dziennik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kompikownia.dziennik.dziennik.model.Subject;
import pl.kompikownia.dziennik.dziennik.model.enums.SubjectLevel;
import pl.kompikownia.dziennik.dziennik.model.enums.SubjectType;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    @Query("SELECT sub FROM Subject sub")
    Set<Subject> getAllSubjects();
    @Query("SELECT sub FROM Subject sub WHERE sub.name=?1 AND sub.level=?2 AND sub.type=?3")
    Subject getSpecificSubject(String name, SubjectLevel level, SubjectType type);
    @Query("SELECT sub FROM Subject sub WHERE sub.ID=?1")
    Subject getSubjectByID(Integer ID);
}
