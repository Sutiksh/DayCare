package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.GroupApi;
import edu.neu.csye6200.model.Group;

import java.util.List;

public class GroupController {
    private GroupApi api = new GroupApi();

    public List<Group> getAllGroups() {
        return api.getAllGroups();
    }

    public void addGroup(Group group) {
        api.addGroup(group);
    }

    public void updateGroup(Group group) { api.updateGroup(group); }

    public void delGroup(Group group) {
        api.deleteGroup(group);
    }

    public void delGroup(int groupId) {
        api.deleteGroup(groupId);
    }
}
