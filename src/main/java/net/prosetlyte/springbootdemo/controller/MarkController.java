package net.prosetlyte.springbootdemo.controller;
import net.prosetlyte.springbootdemo.model.Mark;
import net.prosetlyte.springbootdemo.service.DisciplineService;
import net.prosetlyte.springbootdemo.service.MarkService;
import net.prosetlyte.springbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/mark")
public class MarkController {

    private final MarkService markService;
    private final StudentService studentService;
    private final DisciplineService disciplineService;

    @Autowired
    public MarkController(MarkService markService, StudentService studentService, DisciplineService disciplineService) {
        this.markService = markService;
        this.studentService = studentService;
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Mark> marks = markService.findAll();
        model.addAttribute("mark", marks);
        return "mark/mark-list";
    }

    @GetMapping(value = "/mark-create")
    public String addStudList(Model model) {
        model.addAttribute("mark", new Mark());
        model.addAttribute("allStudents", studentService.findAll());
        model.addAttribute("allDisciplines", disciplineService.findAll());

        return "mark/mark-create";
    }


    @PostMapping(value = "/mark-create")
    public String add(@ModelAttribute("mark") @Valid Mark mark, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allStudents", studentService.findAll());
            model.addAttribute("allDisciplines", disciplineService.findAll());

            return "mark/mark-create";
        }
        markService.saveMark(mark);
        return "redirect:/mark";
    }

    @PostMapping(value = "/mark-update")
    public String updateMark(@ModelAttribute("mark") @Valid Mark mark, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("allStudents", studentService.findAll());
            model.addAttribute("allDisciplines", disciplineService.findAll());

            return "mark/mark-update";
        }
        markService.saveMark(mark);
        return "redirect:/mark";
    }

    @GetMapping("/mark-update/{idMark}")
    public String updateMarkForm(@PathVariable("idMark") Integer idMark, Model model) {
        Mark mark = markService.findById(idMark);
        model.addAttribute("mark", mark);
        model.addAttribute("allStudents", studentService.findAll());
        model.addAttribute("allDisciplines", disciplineService.findAll());
        return "mark/mark-update";
    }

    @GetMapping("/mark-delete/{idMark}")
    public String deleteStudent(@PathVariable("idMark") Integer idMark) {
        markService.deleteById(idMark);
        return "redirect:/mark";
    }

    @GetMapping("/getListGroup")
    public String select(Model model) {
        Iterable<Mark> markList = markService.getListGroup();
        model.addAttribute("mark", markList);

        return "mark/selected";
    }

}