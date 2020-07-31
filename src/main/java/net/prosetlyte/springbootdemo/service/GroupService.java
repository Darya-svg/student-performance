package net.prosetlyte.springbootdemo.service;

import net.prosetlyte.springbootdemo.model.Group;

import net.prosetlyte.springbootdemo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    @Autowired
    public GroupService(GroupRepository groupRepository) {

        this.groupRepository = groupRepository;
    }

    public Group findById(Integer idGroup){

        return groupRepository.getOne(idGroup);
    }

    public List<Group> findAll(){

        return groupRepository.findAll();
    }

    public Group saveGroup(Group group){

        return groupRepository.save(group);
    }

    public void deleteById(Integer idGroup){

        groupRepository.deleteById(idGroup);
    }
}
