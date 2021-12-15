package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.concrete.ConcreteClassroomApi;
import edu.neu.csye6200.api.ClassroomApi;
import edu.neu.csye6200.model.Classroom;

import java.util.List;

public class ClassroomController {
    private final ClassroomApi api = new ConcreteClassroomApi();

    public List<Classroom> getAllClassrooms() {
        return api.getAllClassrooms();
    }

    public void addClassroom(Classroom classroom) {
        api.addClassroom(classroom);
    }

    public void updateClassroom(Classroom classroom) {
        api.updateClassroom(classroom);
    }

    public void deleteClassroom(Classroom classroom) {
        api.deleteClassroom(classroom);
    }
}
