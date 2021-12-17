package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.enums.ClassroomType;

import java.util.List;

public interface ClassroomApi {
    List<Classroom> getAllClassrooms();

    List<Classroom> getAllClassroomsWithType(ClassroomType classroomType);

    List<Classroom> getPartialClassroomsByClassroomType(ClassroomType classroomType);

    Classroom getClassroomWithId(int classroom_id);

    int getMaxClassroomId();

    void addClassroom(Classroom classroom);

    void updateClassroom(Classroom classroom);

    void deleteClassroom(Classroom classroom);
}