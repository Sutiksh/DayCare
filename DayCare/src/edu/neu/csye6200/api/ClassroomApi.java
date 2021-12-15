package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Classroom;

import java.util.List;

public interface ClassroomApi {
    List<Classroom> getAllClassrooms();

    void addClassroom(Classroom classroom);

    void updateClassroom(Classroom classroom);

    void deleteClassroom(Classroom classroom);
}