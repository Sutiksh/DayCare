package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.enums.GroupType;
import edu.neu.csye6200.model.enums.StatusType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupHelper {

	public static List<Group> convertResultSetToGroupList(ResultSet rs, GroupType type, StatusType statusType) {
		List<Group> groupList = new ArrayList<>();
		while (true) {
			try {
				if (!rs.next()) break;
				Group group = new Group();
				group.setGroupId(rs.getLong("group_id"));
				group.setGroupStatus(statusType);
				group.setGroupType(type);
				group.setMaxStudentPerGroup(rs.getInt("max_student_per_group"));
				group.setCurrentStudentCount(rs.getInt("current_student_count"));
				groupList.add(group);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return groupList;
	}

	public static List<Group> convertResultSetToGroupList(ResultSet rs) {
		List<Group> groupList = new ArrayList<>();
		while (true) {
			try {
				if (!rs.next()) break;
				Group group = new Group();
				group.setGroupId(rs.getLong("group_id"));
				group.setGroupStatus(StatusType.valueOf(rs.getString("group_status")));
				group.setGroupType(GroupType.valueOf(rs.getString("group_type")));
				group.setMaxStudentPerGroup(rs.getInt("max_student_per_group"));
				group.setCurrentStudentCount(rs.getInt("current_student_count"));
				groupList.add(group);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return groupList;
	}
}
