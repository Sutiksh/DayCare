package edu.neu.csye6200.api.concrete;

import edu.neu.csye6200.api.StudentApi;
import edu.neu.csye6200.dao.StudentDao;
import edu.neu.csye6200.model.Student;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConcreteStudentApi implements StudentApi {
    private Session session = null;
    private MimeMessage mimeMessage = null;

    @Override
    public int getNumOfStudents() {
        return StudentDao.getNumOfStudentsDao();
    }

    @Override
    public int getNumOfStudentsInGroup(int classroomId, int groupId) {
        return StudentDao.getNumOfStudentsInGroup(classroomId, groupId);
    }

    @Override
    public List<Student> getAllStudents() {
        return StudentDao.getAllStudentsDao();
    }

    @Override
    public List<Student> getAllStudentsInClassroom(int classroomId) {
        return StudentDao.getAllStudentsInClassroomDao(classroomId);
    }

    @Override
    public List<Student> getAllStudentsInGroup(int classroomId, int groupId) {
        return StudentDao.getAllStudentsInGroupDao(classroomId, groupId);
    }

    @Override
    public Student getStudentById(long studentId) {
        return StudentDao.getStudentByIdDao(studentId);
    }

    @Override
    public void addStudent(Student student) {
        StudentDao.addStudentDao(student);
    }

    @Override
    public void updateStudent(Student student) {
        StudentDao.updateStudentDao(student);
    }

    @Override
    public void deleteStudent(Student student) {
        StudentDao.deleteStudentDao(student);
    }

    @Override
    public void deleteStudent(long studentId) {
        StudentDao.deleteStudentDao(studentId);
    }

    @Override
    public void sendMail(List<Student> studentList, String vaccineName, int doseNumber) {
        setupServerProp();
        draftMail(studentList, vaccineName, doseNumber);
        mailingInfo();
        System.out.println("Email Sent Successfully!");
    }

    @Override
    public void sendMail(Student student){
        setupServerProp();
        draftMail(student);
        mailingInfo();
        System.out.println("Email Sent Successfully!");
    }

    @Override
    public void addStudent(List<Student> students) {
        for(Student student : students) {
            addStudent(student);
        }
    }

    private void mailingInfo() {
        System.out.println("Sending Email...");
        String fromEmail ="daycare.ad21@gmail.com";
        String fromPass = "daycare123";
        String emailHost = "smtp.gmail.com";
        try {
            Transport transport = session.getTransport("smtp");
            transport.connect(emailHost, fromEmail, fromPass);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException me){
            me.printStackTrace();
        }

    }

    private void draftMail(List<Student> studentList, String vaccineName, int doseNumber) {
        List<String> emaillist = new ArrayList<>();
        for(Student stud: studentList) {
            emaillist.add(stud.getEmail());
        }
        String sub = "Vaccination Dose Reminder";
        String body = "Your child has pending dose " + doseNumber + " for " + vaccineName + ". Please take the test and update the date of test to us.";
        mimeMessage = new MimeMessage(session);
        try {
            for (int i = 0; i < emaillist.size(); i++) {
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emaillist.get(i)));
            }
            mimeMessage.setSubject(sub);
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart bodypart = new MimeBodyPart();
            bodypart.setText(body);
            multipart.addBodyPart(bodypart);
            mimeMessage.setContent(multipart);
        } catch (MessagingException me){
            me.printStackTrace();
        }
    }

    private void draftMail(Student student) {
        String sub = "Registration Reminder";
        String body = "Your child‘s registration is success!";
        mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(student.getEmail()));
            mimeMessage.setSubject(sub);
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart bodypart = new MimeBodyPart();
            bodypart.setText(body);

            multipart.addBodyPart(bodypart);

            mimeMessage.setContent(multipart);
        } catch (MessagingException me){
            me.printStackTrace();
        }
    }

    private void setupServerProp() {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        session = Session.getDefaultInstance(prop, null);
    }
}
