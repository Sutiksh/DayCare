package edu.neu.csye6200.model;

public class School {
    private long id;
    private long studentId;
    private long teacherId;
    private long groupId;
    private long classroomId;

    public School(long id, long studentId, long teacherId, long groupId, long classroomId) {
        this.id = id;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.classroomId = classroomId;
    }

    public School() {    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }
}