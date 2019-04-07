package pl.kompikownia.dziennik.dziennik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kompikownia.dziennik.dziennik.model.Subject;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    @Query("SELECT sub FROM Subject sub")
    Set<Subject> getAllSubjects();
}
