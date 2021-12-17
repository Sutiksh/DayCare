package edu.neu.csye6200.api.factory;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.enums.ClassroomType;

public class ClassroomFactory {
	
	private static ClassroomFactory instance;
	private ClassroomFactory() {
		instance = null;
	}
	public static ClassroomFactory getInstance() {
		if(instance == null) {
			instance = new ClassroomFactory();
		}
		
		return instance;
	}

	public Classroom getObject(int classroom_id, ClassroomType classroom_type) {
		return new Classroom(classroom_id, classroom_type);
	}

	public Classroom getObject(int classroom_id, ClassroomType classroom_type,
							   int student_num, int teacher_num, int group_num) {
		return new Classroom(classroom_id, classroom_type, student_num, teacher_num, group_num);
	}

}
