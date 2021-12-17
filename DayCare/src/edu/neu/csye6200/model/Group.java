package edu.neu.csye6200.model;

import edu.neu.csye6200.model.enums.GroupType;
import edu.neu.csye6200.model.enums.StatusType;

public class Group {
    private int groupId;
    private int classroomId;
    private long teacherId;

    public Group(int groupId, int classroomId) {
        this.groupId = groupId;
        this.classroomId = classroomId;
    }

    public Group(int groupId, int classroomId, int teacherId) {
        this.groupId = groupId;
        this.classroomId = classroomId;
        this.teacherId = teacherId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}
