package net.prosetlyte.springbootdemo.controller;


import net.prosetlyte.springbootdemo.model.Discipline;
import net.prosetlyte.springbootdemo.model.Group;
import net.prosetlyte.springbootdemo.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public String findAll(Model model){
        List<Discipline> disciplines = disciplineService.findAll();
        model.addAttribute("discipline",disciplines);
        return "discipline/discipline-list";
    }

    @GetMapping( value = "/discipline-create")
    public String createDisciplineForm(Model model){
        model.addAttribute("discipline",new Discipline());
        return "discipline/discipline-create";
    }

    @PostMapping(value = "/discipline-create")
    public String createDiscipline(@ModelAttribute("discipline")@Valid Discipline discipline, BindingResult result){
        if(result.hasErrors()){
            return"discipline/discipline-create";
        }
        disciplineService.saveDiscipline(discipline);
        return "redirect:/discipline";
    }

    @PostMapping(value = "/discipline-update")
    public String updateDiscipline(@ModelAttribute("discipline")@Valid Discipline discipline, BindingResult result){
        if(result.hasErrors()){
            return"discipline/discipline-update";
        }
        disciplineService.saveDiscipline(discipline);
        return "redirect:/discipline";
    }

    @GetMapping(value = "/discipline-update/{idDiscipline}")
    public String updateDisciplineForm(@PathVariable("idDiscipline") Integer idDiscipline, Model model){
        Discipline discipline = disciplineService.findById(idDiscipline);
        model.addAttribute("discipline",discipline);
        return "discipline/discipline-update";
    }

    @GetMapping(value = "/discipline-delete/{idDiscipline}")
    public String deleteDiscipline(@PathVariable("idDiscipline") Integer idDiscipline){
        disciplineService.deleteById(idDiscipline);
        return"redirect:/discipline";
    }




}
