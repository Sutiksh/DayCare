package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.GroupApi;
import edu.neu.csye6200.api.concrete.ConcreteGroupApi;
import edu.neu.csye6200.model.Group;

import java.util.List;

public class GroupController {
    private final GroupApi api = new ConcreteGroupApi();

    public List<Group> getAllGroups() {
        return api.getAllGroups();
    }

    public List<Group> getAllGroupsInClassroom(int classroomId) {
        return api.getAllGroupsInClassroom(classroomId);
    }

    public void addGroup(Group group) {
        api.addGroup(group);
    }

    public void updateGroup(Group group) { api.updatedGroup(group); }

    public void delGroup(Group group) {
        api.delGroup(group);
    }
}
