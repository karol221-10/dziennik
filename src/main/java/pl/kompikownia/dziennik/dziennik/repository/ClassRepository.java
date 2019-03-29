package pl.kompikownia.dziennik.dziennik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kompikownia.dziennik.dziennik.model.SchoolClass;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ClassRepository extends JpaRepository<SchoolClass,Long> {

    @Query("SELECT sch FROM SchoolClass sch")
    List<SchoolClass> getAllClasses();
}
