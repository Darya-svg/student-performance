package net.prosetlyte.springbootdemo.controller;
import net.prosetlyte.springbootdemo.model.Mark;
import net.prosetlyte.springbootdemo.model.Student;
import net.prosetlyte.springbootdemo.service.GroupService;
import net.prosetlyte.springbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }



    @GetMapping
    public String findAll(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("student",students);
        return "student/student-list";
    }

    @GetMapping(value = "/student-create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("allGroups", groupService.findAll());
        return "student/student-create";
    }


    @PostMapping(value = "/student-create")
    public String createStudent(@Valid @ModelAttribute("student")  Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allGroups", groupService.findAll());
            return "student/student-create";
        }
        studentService.saveStudent(student);
        return "redirect:/student";
    }

    @PostMapping("/student-update")
    public String updateStudent(@Valid @ModelAttribute("student")  Student student, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("allGroups", groupService.findAll());
            return "student/student-update";
        }
        studentService.saveStudent(student);
        return "redirect:/student";
    }



    @GetMapping("/student-update/{idStudent}")
    public String updateStudentForm(@PathVariable("idStudent") Integer idStudent, Model model){
        Student student = studentService.findById(idStudent);
        model.addAttribute("student",student);
        model.addAttribute("allGroups", groupService.findAll());
        return "student/student-update";
    }

    @GetMapping("/student-delete/{idStudent}")
    public String deleteStudent(@PathVariable("idStudent") Integer idStudent){
        studentService.deleteById(idStudent);
        return"redirect:/student";
    }
    @GetMapping("/getAllList")
    public String select(Model model) {
        Iterable<Student> studentList = studentService.getAllList();
        model.addAttribute("student", studentList);

        return "student/selected";
    }
}
