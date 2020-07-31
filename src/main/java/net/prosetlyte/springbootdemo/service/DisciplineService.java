package net.prosetlyte.springbootdemo.service;


import net.prosetlyte.springbootdemo.model.Discipline;
import net.prosetlyte.springbootdemo.model.Group;
import net.prosetlyte.springbootdemo.repository.DisciplineRepository;
import net.prosetlyte.springbootdemo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;
    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {

        this.disciplineRepository = disciplineRepository;
    }

    public Discipline findById(Integer idDiscipline){

        return disciplineRepository.getOne(idDiscipline);
    }

    public List<Discipline> findAll(){

        return disciplineRepository.findAll();
    }

    public Discipline saveDiscipline(Discipline discipline){

        return disciplineRepository.save(discipline);
    }

    public void deleteById(Integer idDiscipline){

        disciplineRepository.deleteById(idDiscipline);
    }
}
