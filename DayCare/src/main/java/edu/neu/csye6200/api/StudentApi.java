package edu.neu.csye6200.api;

import edu.neu.csye6200.api.abstractClass.AbstractStudent;
import edu.neu.csye6200.api.helper.StudentHelper;
import edu.neu.csye6200.dao.StudentDao;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.data.GetAllStudentData;
import edu.neu.csye6200.model.form.AddStudentForm;
import edu.neu.csye6200.model.form.DeleteStudentForm;
import edu.neu.csye6200.model.form.UpdateStudentForm;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentApi extends AbstractStudent {
    private final StudentDao studentDao = new StudentDao();
    private static final int[] AllMinAge = {6, 13, 25, 36, 48, 60};
    private static final int[] AllMaxAge = {12, 24, 35, 47, 59, Integer.MAX_VALUE};
    private Session session = null;
    private MimeMessage mimeMessage = null;
    @Override
    public int getNumOfStudents() {
        return 0;
    }

    @Override
    public GetAllStudentData getAllStudents() {
        return new GetAllStudentData();
    }

    @Override
    public void addStudent(AddStudentForm studentForm) {
        //Todo Validations required

        //Converting form to Student object
        Student student = StudentHelper.convertToStudent(studentForm);

        // Query the student info from database and cal the age
        addStudent(student);
    }

    @Override
    public void updateStudent(Student student){
        // Get student data if exists from database
        ResultSet rs = studentDao.getStudentFromDb(student);
        // create student object from data
        Student dbStudent = StudentHelper.convertToStudent(rs);

        if(dbStudent.getStudentId()==0){
            // update the data in the database
            studentDao.updateStudent(dbStudent);
        }else{
            // create a new student
            studentDao.addStudentToDb(student);
        }
    }

    public void updateStudent(UpdateStudentForm studentForm){
        //Todo Validations required

        Student student = StudentHelper.convertToStudent(studentForm);

        updateStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        // Deleting student using student obj from database
        studentDao.deleteStudentFromDb(student);
    }

    @Override
    public void deleteStudent(long studentId) {
        // Deleting student using student id from database
        studentDao.deleteStudentFromDb(studentId);
    }

    public void setRegistrationDate(String registrationDate, Student student){
        // Setting registration date using student obj
        student.setRegistrationDate(registrationDate);
        // Updating the student object in the database
        updateStudent(student);
    }

    public String getRegistrationDate(long studentId) {
        // Retrieving student data from database
        ResultSet rs = studentDao.getRegDateStudentFromDb(studentId);
        // Creating student from the data
        Student student = null;
        student = StudentHelper.convertToStudent(rs);

        // Returning the registration date
        return student.getRegistrationDate();
    }

    public void addStudent(List<Student> studentList) {
        for(Student student : studentList) {
            addStudent(student);
        }
    }

    public List<Student> getAllStudentByPhoneNo(List<Long> phoneList) {
        ResultSet rs = studentDao.getStudentsByPhoneNo(phoneList);
        return StudentHelper.convertToStudentList(rs);
    }

    public void addStudent(Student student) {
        ResultSet rs = studentDao.getStudentFromDb(student);
        Student studentDB = StudentHelper.convertToStudent(rs);
        if(studentDB.getStudentId()==0) {
            studentDao.addStudentToDb(student);
        } else {
            System.out.println("Record already exists");
        }
    }

    public void deleteStudent(DeleteStudentForm studentForm) {
        deleteStudent(studentForm.getStudentId());
    }

    public void sendMail(List<Student> studentList, String vaccineName, int doseNumber) {
        StudentApi studentApi = new StudentApi();
        studentApi.setupServerProp();
        studentApi.draftMail(studentList, vaccineName, doseNumber);
        studentApi.mailingInfo();
        System.out.println("Email Sent Successfully!");
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

    private MimeMessage draftMail(List<Student> studentList, String vaccineName, int doseNumber) {
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
            bodypart.setContent(body, "html/text");
            multipart.addBodyPart(bodypart);
            mimeMessage.setContent(multipart);
        } catch (MessagingException me){
            me.printStackTrace();
        }
        return mimeMessage;

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

