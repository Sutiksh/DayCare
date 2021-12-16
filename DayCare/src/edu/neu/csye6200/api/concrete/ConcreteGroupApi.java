package edu.neu.csye6200.api.concrete;

import edu.neu.csye6200.api.GroupApi;
import edu.neu.csye6200.dao.GroupDao;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.enums.GroupType;
import edu.neu.csye6200.model.enums.StatusType;

import java.util.List;

public class ConcreteGroupApi implements GroupApi {
    @Override
    public int getNumOfGroups() {
        return GroupDao.getNumOfGroupsDao();
    }

    @Override
    public List<Group> getAllGroups() {
        return GroupDao.getAllGroupsDao();
    }

    @Override
    public List<Group> getAllGroupsInClassroom(int classroomId) {
        return GroupDao.getAllGroupsInClassroomDao(classroomId);
    }

    public List<Group> getPartialGroupsByGroupType(GroupType groupType) {
        return GroupDao.getPartialGroupsByGroupType(groupType);
    }

    @Override
    public void addGroup(Group group) {
        GroupDao.addGroupDao(group);
    }

    @Override
    public void updatedGroup(Group group) {
        GroupDao.updatedGroupDao(group);
    }

    @Override
    public void delGroup(Group group) {
        GroupDao.delGroupDao(group);
    }
}
