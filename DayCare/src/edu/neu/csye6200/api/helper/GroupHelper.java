package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Group;
import static edu.neu.csye6200.utils.ConvertUtil.*;

import java.sql.ResultSet;
import java.sql.SQLException;

//
//import edu.neu.csye6200.api.ClassroomApi;
//import edu.neu.csye6200.api.factory.ClassroomFactory;
//import edu.neu.csye6200.api.factory.GroupFactory;
//import edu.neu.csye6200.model.*;
//import edu.neu.csye6200.utils.FileUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ListIterator;
//import java.util.stream.Collectors;
//
//import static edu.neu.csye6200.utils.ConvertUtil.calAge;
//
public class GroupHelper {
//
//	static String studentFile = "students.csv";
//	static String teachersFile = "teachers.csv";
//
//	public static void groupMe() {
//
//		List<Student> students = FileUtil.readStudentFromCSV(studentFile);
//		List<Teacher> teachers = FileUtil.readTeacherFromCSV(teachersFile);
//
//		List<Student> sixToTwelve = students.stream().filter(student -> calAge(student.getDateOfBirth()) >= 6 && calAge(student.getDateOfBirth()) <= 12).collect(Collectors.toList());
//		List<Student> thirteenToTwentyFour = students.stream().filter(student -> calAge(student.getDateOfBirth()) >= 13 && calAge(student.getDateOfBirth()) <= 24).collect(Collectors.toList());
//		List<Student> twentyFiveToThirtyFive = students.stream().filter(student -> calAge(student.getDateOfBirth()) >= 25 && calAge(student.getDateOfBirth()) <= 35).collect(Collectors.toList());
//		List<Student> thirtySixToFortySeven = students.stream().filter(student -> calAge(student.getDateOfBirth()) >= 36 && calAge(student.getDateOfBirth()) <= 47).collect(Collectors.toList());
//		List<Student> fortyEightToFiftyNine = students.stream().filter(student -> calAge(student.getDateOfBirth()) >= 48 && calAge(student.getDateOfBirth()) <= 59).collect(Collectors.toList());
//		List<Student> sixtyAndUp = students.stream().filter(student -> calAge(student.getDateOfBirth()) >= 60).collect(Collectors.toList());
//		List<List<Student>> studentAgeGroups = new ArrayList<>();
//
//		studentAgeGroups.add(sixToTwelve);
//		studentAgeGroups.add(thirteenToTwentyFour);
//		studentAgeGroups.add(twentyFiveToThirtyFive);
//		studentAgeGroups.add(thirtySixToFortySeven);
//		studentAgeGroups.add(fortyEightToFiftyNine);
//		studentAgeGroups.add(sixtyAndUp);
//
//		ListIterator<List<Student>> li = studentAgeGroups.listIterator();
//		while(li.hasNext()) {
//			List<Student> s = li.next();
//			if(s.size() == 0) {
//				li.remove();
//			}
//		}
//
//		for(List<Student> s : studentAgeGroups) {
//			System.out.println(s);
//		}
//
//
//		int flag = 0;
//		while(flag < studentAgeGroups.size()) {
//
//			if(flag == 0) {
//				System.out.println("calling 0");
//				parseAndAdd(studentAgeGroups.get(flag), 4, 3);
//			} else if(flag == 1) {
//				System.out.println("calling 1");
//				parseAndAdd(studentAgeGroups.get(flag), 5, 3);
//			} else if(flag == 2) {
//				System.out.println("calling 2");
//				studentAgeGroups.get(flag);
//				parseAndAdd(studentAgeGroups.get(flag), 6, 3);
//			} else if(flag == 3) {
//				System.out.println("calling 3");
//				parseAndAdd(studentAgeGroups.get(flag), 8, 3);
//			} else if(flag == 4) {
//				System.out.println("calling 4");
//				parseAndAdd(studentAgeGroups.get(flag), 12, 2);
//			} else if(flag == 5) {
//				parseAndAdd(studentAgeGroups.get(flag), 15, 2);
//			}
//
//			flag = flag + 1;
//
//		}
//
//		parseAddTeacher(teachers, School.classrooms);
//
//	}
//
//	public static void parseAndAdd(List<Student> studs, int size, int classSize) {
//		System.out.println("i am  in parseaddstud");
//		System.out.println(studs);
//		System.out.println(size);
//		int numGroups = 0;
//		if(studs.size()%size == 0) {
//			numGroups = studs.size()/size;
//
//		} else {
//			numGroups = studs.size()/size + 1;
//		}
//		List<Group> groups = new ArrayList<>();
//		int temp=0;
//		for(int i = 0; i < numGroups; i++) {
//			groups.add(GroupFactory.getInstance().getObject());
//			for(int j = 0; j < size; j++) {
//				if((temp+j)<studs.size()) {
//					groups.get(i).addStudent(studs.get(temp+j));
//				}
//			}
//			temp = temp + size;
//		}
//
//		List<Classroom> classes = new ArrayList<>();
//		int tempC = 0;
//		int numClassrooms = 0;
//		if(groups.size()%classSize == 0) {
//			numClassrooms = groups.size()/classSize;
//
//		} else {
//			numClassrooms = groups.size()/classSize + 1;
//		}
//
//		System.out.println("number of classrooms");
//		System.out.println(groups.size());
//		System.out.println(numClassrooms);
//		for(int i = 0; i<numClassrooms; i++) {
//			classes.add(ClassroomFactory.getInstance().getObject());
//			for(int j = 0; j < classSize; j++) {
//				if((tempC+j) < groups.size()) {
//					classes.get(i).addGroup(groups.get(tempC + j));
//				}
//			}
//
//			tempC = tempC + classSize;
//		}
//
//		School.classrooms.addAll(classes);
//	}
//
//
//	public static void parseAddTeacher(List<Teacher> t, List<ClassroomApi> classrooms) {
//		int currTF = 0;
//		for(ClassroomApi cl : classrooms) {
//			for(Group g : cl.getAllGroups()) {
//				g.setTeacher(t.get(currTF));
//				System.out.println("i am  in parseaddteacher");
//				System.out.println(g);
//				System.out.println(t.get(currTF));
//				currTF = currTF + 1;
//				if(currTF == t.size()) {
//					currTF = 0;
//				}
//			}
//		}
//
//	}

    public static Group createGroup(ResultSet rs) throws SQLException {
        Group group = new Group(
                stringToInt(rs.getString("group_id")),
                stringToInt(rs.getString("classroom_id")),
                stringToInt(rs.getString("teacher_id")));
        return group;
    }


}
