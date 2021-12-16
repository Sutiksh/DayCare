package edu.neu.csye6200.api.abstractClass;

import edu.neu.csye6200.model.Group;

import java.util.List;
public abstract class AbstractGroup {

	public abstract List<Group> getAllGroups();

	public abstract void addGroup(Group group);

	public abstract void updateGroup(Group group);

	public abstract void deleteGroup(Group group);

	public abstract void deleteGroup(int groupId);
}