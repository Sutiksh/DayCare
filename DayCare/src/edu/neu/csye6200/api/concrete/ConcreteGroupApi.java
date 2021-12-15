package edu.neu.csye6200.api.concrete;

import edu.neu.csye6200.api.GroupApi;
import edu.neu.csye6200.dao.GroupDao;
import edu.neu.csye6200.model.Group;

import java.util.ArrayList;
import java.util.List;

public class ConcreteGroupApi implements GroupApi {
    @Override
    public List<Group> getAllGroups() {
        return GroupDao.getAllGroupsDao();
    }

    @Override
    public List<Group> getAllGroupsInClassroom(int classroomId) {
        return GroupDao.getAllGroupsInClassroomDao(classroomId);
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
