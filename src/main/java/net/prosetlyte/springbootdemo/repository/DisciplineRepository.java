package net.prosetlyte.springbootdemo.repository;

import net.prosetlyte.springbootdemo.model.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline,Integer> {
}
