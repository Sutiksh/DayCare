package edu.neu.csye6200.model;

import edu.neu.csye6200.model.enums.ClassroomType;
import edu.neu.csye6200.model.enums.StatusType;

public class Classroom {

	private long classroomId;
	private int currentGroupCount;
	private int maxGroupPerCount;
	private ClassroomType classroomType;
	private StatusType classroomStatusType;

	public Classroom(long classroomId, int currentGroupCount, int maxGroupPerCount, ClassroomType classroomType, StatusType classroomStatusType) {
		this.classroomId = classroomId;
		this.currentGroupCount = currentGroupCount;
		this.maxGroupPerCount = maxGroupPerCount;
		this.classroomType = classroomType;
		this.classroomStatusType = classroomStatusType;
	}

	public Classroom() {
		this.currentGroupCount = 0;
	}

	public long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}

	public int getCurrentGroupCount() {
		return currentGroupCount;
	}

	public void setCurrentGroupCount(int currentGroupCount) {
		this.currentGroupCount = currentGroupCount;
	}

	public int getMaxGroupPerCount() {
		return maxGroupPerCount;
	}

	public void setMaxGroupPerCount(int maxGroupPerCount) {
		this.maxGroupPerCount = maxGroupPerCount;
	}

	public ClassroomType getClassroomType() {
		return classroomType;
	}

	public void setClassroomType(ClassroomType classroomType) {
		this.classroomType = classroomType;
	}

	public StatusType getClassroomStatus() {
		return classroomStatusType;
	}

	public void setClassroomStatus(StatusType classroomStatusType) {
		this.classroomStatusType = classroomStatusType;
	}
}