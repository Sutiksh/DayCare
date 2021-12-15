package edu.neu.csye6200.utils;

import edu.neu.csye6200.api.concrete.ConcreteStudentApi;
import edu.neu.csye6200.api.concrete.ConcreteTeacherApi;
import edu.neu.csye6200.api.helper.StudentHelper;
import edu.neu.csye6200.api.helper.TeacherHelper;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	private static final ConcreteTeacherApi teacherApi = new ConcreteTeacherApi();
	private static final ConcreteStudentApi studentApi = new ConcreteStudentApi();

	public static void writeStudentToCSV(String fileName, List<Student> studentArrays){
		try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName))){
			for (Student stud : studentArrays) {
				br.write(String.valueOf(stud.getStudentId()));
				br.append(",");
				br.write(String.valueOf(stud.getFirstName()));
				br.append(",");
				br.write(String.valueOf(stud.getLastName()));
				br.append(",");
				br.write(String.valueOf(stud.getAddress()));
				br.append(",");
				br.write(String.valueOf(stud.getDateOfBirth()));
				br.append(",");
				br.write(String.valueOf(stud.getParentName()));
				br.append(",");
				br.write(String.valueOf(stud.getEmail()));
				br.append(",");
				br.write(String.valueOf(stud.getRegistrationDate()));
				br.append(",");
				br.write(String.valueOf(stud.getPhoneNum()));
				br.append(",");
				br.write(String.valueOf(stud.getRating()));
				br.append(",");
			 	br.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

//	public static List<Student> readStudentFromCSV(String fileName){
//		List<Student> studentRoster = new ArrayList<>();
//		try (FileReader fr = new FileReader(fileName);
//			BufferedReader br = new BufferedReader(fr)) {
//			String line = br.readLine();
//			while(line != null) {
//				String[] attributes = line.split(",");
//				Student student = StudentHelper.createStudent(attributes);
//				studentApi.addStudent(student);
//				line = br.readLine();
//			}
//		} catch (IOException ioe) {
//	        ioe.printStackTrace();
//	    }
//		return studentRoster;
//	}

	public static void writeTeacherToCSV(String fileName, List<Teacher> teacherArrays){
		try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName))) {
			for (Teacher teach : teacherArrays) {
				br.write(String.valueOf(teach.getTeacherId()));
				br.append(",");
				br.write(String.valueOf(teach.getFirstName()));
				br.append(",");
				br.write(String.valueOf(teach.getLastName()));
				br.append(",");
				br.write(String.valueOf(teach.getAddress()));
				br.append(",");
				br.write(String.valueOf(teach.getDateOfBirth()));
				br.append(",");
				br.write(String.valueOf(teach.getParentName()));
				br.append(",");
				br.write(String.valueOf(teach.getEmail()));
				br.append(",");
				br.write(String.valueOf(teach.getPhoneNum()));
				br.append(",");
				br.write(String.valueOf(teach.getRating()));
				br.append(",");
			 	br.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

//	public static List<Teacher> readTeacherFromCSV(String fileName){
//		List<Teacher> teacherRoster = new ArrayList<>();
//		try (FileReader fr = new FileReader(fileName);
//			BufferedReader br = new BufferedReader(fr)) {
//			String line = br.readLine();
//			while(line != null) {
//				String[] attributes = line.split(",");
//				Teacher teacher = TeacherHelper.createTeacher(attributes);
//				teacherApi.addTeacher(teacher);
//				line = br.readLine();
//			}
//		} catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//		return teacherRoster;
//	}
}