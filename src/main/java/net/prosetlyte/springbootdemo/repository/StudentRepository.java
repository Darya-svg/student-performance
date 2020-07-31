package net.prosetlyte.springbootdemo.repository;

import net.prosetlyte.springbootdemo.model.Mark;
import net.prosetlyte.springbootdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value ="SELECT * FROM students INNER JOIN grops ON grops.idGroup = students.idGroup WHERE grops.nameGroup='17-SBK'",nativeQuery = true)
    Iterable<Student> getAllList();
    //запросы


}
