package edu.neu.csye6200.api.factory;

import edu.neu.csye6200.model.Group;

public class GroupFactory {
	
	private static GroupFactory instance;
	
	private GroupFactory() {
		instance = null;
	}
	public static GroupFactory getInstance() {
		if(instance == null) {
			instance = new GroupFactory();
		}
		return instance;
	}

	public Group getObject(int group_id, int classroom_id) {
		return new Group(group_id, classroom_id);
	}

	public Group getObject(int group_id, int classroom_id, int teacher_id ) {
		return new Group(group_id, classroom_id, teacher_id);
	}
}
