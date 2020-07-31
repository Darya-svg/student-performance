package net.prosetlyte.springbootdemo.repository;
import net.prosetlyte.springbootdemo.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarkRepository extends JpaRepository<Mark,Integer> {
    @Query(value ="SELECT * FROM students JOIN marks ON students.idStudent = marks.idStudent +" +
            "JOIN disciplines ON marks.idDiscipline = disciplines.idDiscipline +" +
            "WHERE students.idGroup = 1",nativeQuery = true)
    Iterable<Mark> getListGroup();
}
