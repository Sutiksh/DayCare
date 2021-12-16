package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.form.AddTeacherForm;

public class TeacherHelper {

    public static Teacher createTeacher(String[] attributes) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(attributes[0]);
        teacher.setLastName(attributes[1]);
        teacher.setDateOfBirth(attributes[2]);
        teacher.setAddress(attributes[3]);
        teacher.setEmail(attributes[4]);
        teacher.setPhoneNum(Integer.parseInt(attributes[5]));
        teacher.setRating(Double.parseDouble(attributes[6]));
        return teacher;
    }

    public static Teacher convertToTeacher(AddTeacherForm teacherForm) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherForm.getFirstName());
        teacher.setLastName(teacherForm.getLastName());
        teacher.setAddress(teacherForm.getAddress());
        teacher.setEmail(teacherForm.getEmail());
        teacher.setDateOfBirth(teacherForm.getDateOfBirth());
        teacher.setParentName(teacherForm.getParentName());
        teacher.setPhoneNum(teacherForm.getPhoneNum());
        teacher.setRating(teacherForm.getRating());
        return teacher;
    }
}
