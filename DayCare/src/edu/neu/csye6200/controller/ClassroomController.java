package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.ClassroomApi;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.data.GetAllClassroomData;

import java.util.List;

public class ClassroomController {

    private final ClassroomApi api = new ClassroomApi();

    public GetAllClassroomData getAllClassrooms() {
        return api.getAllClassrooms();
    }

}
