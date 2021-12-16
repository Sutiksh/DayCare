package edu.neu.csye6200.api.abstractClass;

import edu.neu.csye6200.model.data.GetAllClassroomData;

public abstract class AbstractClassroom {

	public abstract int getClassroomIdByStudentId(long studentId);

	public abstract int getClassroomIdByTeacherId(long teacherId);

	public abstract GetAllClassroomData getAllClassrooms();

	public abstract int getNumOfClassrooms();
}