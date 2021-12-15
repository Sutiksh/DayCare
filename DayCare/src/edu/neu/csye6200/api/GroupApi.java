package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Group;

import java.util.List;
public interface GroupApi {
    List<Group> getAllGroups();

    List<Group> getAllGroupsInClassroom(int classroomId);

    void addGroup(Group group);

    void updatedGroup(Group group);

    void delGroup(Group group);
}