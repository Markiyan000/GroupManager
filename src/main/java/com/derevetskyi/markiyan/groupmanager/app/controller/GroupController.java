package com.derevetskyi.markiyan.groupmanager.app.controller;

import com.derevetskyi.markiyan.groupmanager.app.dto.GroupDto;
import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import com.derevetskyi.markiyan.groupmanager.app.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
@CrossOrigin
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupDto> findAll() {
        List<Group> groups = groupService.findAll();

        return groups.stream().map(GroupDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Group findById(@PathVariable Long id) {
        return groupService.findById(id);
    }
}
