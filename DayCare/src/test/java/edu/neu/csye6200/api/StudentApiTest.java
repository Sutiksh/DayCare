package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Student;
import org.junit.Test;

public class StudentApiTest {
    @Test
    public void testAddStudent(){
        StudentApi studentApi = new StudentApi();
        Student student = new Student();
        student.setFirstName("Abc");
        student.setLastName("last");
        student.setEmail("abc@gmail.com");
        student.setAge(10);
        student.setPhoneNum(9876543210L);
        student.setDateOfBirth("2020/01/23");
        student.setAddress("30 South Square");
        student.setRegistrationDate("2021/01/22");
        student.setAnnualRegistrationDate("2022/01/22");
        student.setParentName("Adam");
        studentApi.addStudent(student);
    }

    @Test
    public void testDeleteStudentById(){
        StudentApi studentApi = new StudentApi();
        studentApi.deleteStudent(3);
    }

//    @Test
//    public void testStudentCD(){
//        for(int i=0; i<7; i++){
//            testAddStudent();
//            testDeleteStudentById();
//        }
//    }
}
