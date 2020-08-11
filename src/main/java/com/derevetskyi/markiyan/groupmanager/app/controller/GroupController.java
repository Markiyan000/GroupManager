package com.derevetskyi.markiyan.groupmanager.app.controller;

import com.derevetskyi.markiyan.groupmanager.app.wrapper.JacksonWrapper;
import com.derevetskyi.markiyan.groupmanager.app.model.Group;
import com.derevetskyi.markiyan.groupmanager.app.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin
public class GroupController {

    private GroupService groupService;

    private JacksonWrapper wrapper;

    @Autowired
    public GroupController(GroupService groupService, JacksonWrapper wrapper) {
        this.groupService = groupService;
        this.wrapper = wrapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MappingJacksonValue findAll() {
        List<Group> groups = groupService.findAll();

        return wrapper.wrap(groups, "GroupId", "id", "name", "dateOfCreation");
    }
}
