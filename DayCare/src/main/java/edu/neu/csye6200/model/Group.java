package edu.neu.csye6200.model;

import edu.neu.csye6200.model.enums.GroupType;
import edu.neu.csye6200.model.enums.StatusType;

public class Group {

	private long groupId;
	private int currentStudentCount;
	private int maxStudentPerGroup;
	private GroupType groupType;
	private StatusType groupStatusType;

	public Group(long groupId, int currentStudentCount, int maxStudentPerGroup, GroupType groupType, StatusType groupStatusType) {
		this.groupId = groupId;
		this.currentStudentCount = currentStudentCount;
		this.maxStudentPerGroup = maxStudentPerGroup;
		this.groupType = groupType;
		this.groupStatusType = groupStatusType;
	}

	public Group() {
		this.currentStudentCount = 0;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public int getCurrentStudentCount() {
		return currentStudentCount;
	}

	public void setCurrentStudentCount(int currentStudentCount) {
		this.currentStudentCount = currentStudentCount;
	}

	public int getMaxStudentPerGroup() {
		return maxStudentPerGroup;
	}

	public void setMaxStudentPerGroup(int maxStudentPerGroup) {
		this.maxStudentPerGroup = maxStudentPerGroup;
	}

	public GroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	public StatusType getGroupStatus() {
		return groupStatusType;
	}

	public void setGroupStatus(StatusType groupStatusType) {
		this.groupStatusType = groupStatusType;
	}
}
