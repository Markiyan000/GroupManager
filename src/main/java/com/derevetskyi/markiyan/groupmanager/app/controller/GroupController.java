package com.derevetskyi.markiyan.groupmanager.app.controller;

import com.derevetskyi.markiyan.groupmanager.app.dto.GroupDto;
import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import com.derevetskyi.markiyan.groupmanager.app.model.Teacher;
import com.derevetskyi.markiyan.groupmanager.app.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<GroupDto> findAll() {
        List<Group> groups = groupService.findAll();

        return groups.stream().map(GroupDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group findById(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Group saveGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @GetMapping("/{id}/curator/{curatorId}")
    @ResponseStatus(HttpStatus.OK)
    public void addCurator(@PathVariable Long id, @PathVariable Long curatorId) {
        groupService.addCurator(id, curatorId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeGroup(@PathVariable Long id) {
        groupService.removeGroup(id);
    }
}
