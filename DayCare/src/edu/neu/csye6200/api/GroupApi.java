package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.enums.GroupType;
import edu.neu.csye6200.model.enums.StatusType;

import java.util.List;
public interface GroupApi {

    int getNumOfGroups();

    List<Group> getAllGroups();

    List<Group> getAllGroupsInClassroom(int classroomId);

    List<Group> getPartialGroupsByGroupType(GroupType groupType);

    void addGroup(Group group);

    void updatedGroup(Group group);

    void delGroup(Group group);
}