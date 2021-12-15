package edu.neu.csye6200.model;

import edu.neu.csye6200.model.enums.ClassroomType;

public class Classroom {
    private int classroomId;
    private ClassroomType classroomType;
    private int numOfStudent;
    private int numOfTeacher;
    private int numOfGroup;

    public Classroom(int classroomId, ClassroomType classroomType) {
        this.classroomId = classroomId;
        this.classroomType = classroomType;
        this.numOfStudent = 0;
        this.numOfTeacher = 0;
        this.numOfGroup = 0;
    }

    public Classroom(int classroomId, ClassroomType classroomType, int numOfStudent, int numOfTeacher, int numOfGroup) {
        this.classroomId = classroomId;
        this.classroomType = classroomType;
        this.numOfStudent = numOfStudent;
        this.numOfTeacher = numOfTeacher;
        this.numOfGroup = numOfGroup;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public ClassroomType getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(ClassroomType classroomType) {
        this.classroomType = classroomType;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }

    public int getNumOfTeacher() {
        return numOfTeacher;
    }

    public void setNumOfTeacher(int numOfTeacher) {
        this.numOfTeacher = numOfTeacher;
    }

    public int getNumOfGroup() {
        return numOfGroup;
    }

    public void setNumOfGroup(int numOfGroup) {
        this.numOfGroup = numOfGroup;
    }
}