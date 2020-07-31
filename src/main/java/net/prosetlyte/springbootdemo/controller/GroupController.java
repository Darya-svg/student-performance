package net.prosetlyte.springbootdemo.controller;

import net.prosetlyte.springbootdemo.model.Group;

import net.prosetlyte.springbootdemo.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public String findAll(Model model){
        List<Group> groups = groupService.findAll();
        model.addAttribute("group",groups);
        return "group/group-list";
    }

    @GetMapping(value = "/group-create")
    public String createGroupForm(Model model){
        model.addAttribute("group",new Group());
        return "group/group-create";
    }

    @PostMapping(value = "/group-create")
    public String createGroup(@ModelAttribute("group")@Valid Group group, BindingResult result){
        if(result.hasErrors()){
            return"group/group-create";
        }
        groupService.saveGroup(group);
        return "redirect:/group";
    }

    @PostMapping(value = "/group-update")
    public String updateGroup(@ModelAttribute("group")@Valid Group group,BindingResult result){
        if(result.hasErrors()){
            return "group/group-update";
        }
        groupService.saveGroup(group);
        return "redirect:/group";
    }


    @GetMapping(value = "/group-update/{idGroup}")
    public String updateGroupForm(@PathVariable("idGroup") Integer idGroup, Model model){
        Group group = groupService.findById(idGroup);
        model.addAttribute("group",group);
        return "group/group-update";
    }
    @GetMapping("/group-delete/{idGroup}")
    public String deleteGroup(@PathVariable("idGroup") Integer idGroup){
        groupService.deleteById(idGroup);
        return"redirect:/group";
    }


}
