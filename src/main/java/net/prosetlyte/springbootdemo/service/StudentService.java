package net.prosetlyte.springbootdemo.service;

import net.prosetlyte.springbootdemo.model.Mark;
import net.prosetlyte.springbootdemo.model.Student;
import net.prosetlyte.springbootdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public Student findById(Integer idStudent){
        return studentRepository.getOne(idStudent);
    }

    public List<Student> findAll(){

        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){

        return studentRepository.save(student);

    }

    public void deleteById(Integer idStudent){

        studentRepository.deleteById(idStudent);
    }
    public Iterable<Student> getAllList() {
        return studentRepository.getAllList();
    }
}
