package edu.neu.csye6200.model.form;

public class DeleteStudentForm {

    private long studentId;
    private long phoneNo;
    private long email;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public long getEmail() {
        return email;
    }

    public void setEmail(long email) {
        this.email = email;
    }
}
