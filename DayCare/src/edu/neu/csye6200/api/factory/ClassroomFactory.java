package edu.neu.csye6200.api.factory;

import edu.neu.csye6200.model.Classroom;

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
	
	public Classroom getObject() {
		return new Classroom();
	}

}
