package net.prosetlyte.springbootdemo.repository;


import net.prosetlyte.springbootdemo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Integer> {
}
