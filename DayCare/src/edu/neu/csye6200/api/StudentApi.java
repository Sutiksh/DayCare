package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Student;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public interface StudentApi {

    int getNumOfStudents();

    int getNumOfStudentsInGroup(int classroomId, int groupId);

    List<Student> getAllStudents();

    List<Student> getAllStudentsInClassroom(int classroomId);

    List<Student> getAllStudentsInGroup(int classroomId, int groupId);

    Student getStudentById(long studentId);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    void deleteStudent(long studentId);

    void sendMail(List<Student> studentList, String vaccineName, int doseNumber);

    void sendMail(Student student);

    void addStudent(List<Student> students);
}