package edu.neu.csye6200.model.form;

public class UpdateStudentForm {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String parentName;
    private double review;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }
}
