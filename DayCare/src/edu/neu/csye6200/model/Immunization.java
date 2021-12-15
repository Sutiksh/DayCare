package edu.neu.csye6200.model;

import java.time.LocalDate;

public class Immunization {
    private String immunizationName;
    private int studentId;
    private long doseId1;
    private LocalDate doseDate1;
    private long doseId2;
    private LocalDate doseDate2;
    private long doseId3;
    private LocalDate doseDate3;
    private long doseId4;
    private LocalDate doseDate4;

    public Immunization(String immunizationName, int studentId, long doseId1, LocalDate doseDate1) {
        this.immunizationName = immunizationName;
        this.studentId = studentId;
        this.doseId1 = doseId1;
        this.doseDate1 = doseDate1;
    }

    public Immunization(String immunizationName, int studentId, long doseId1, LocalDate doseDate1, long doseId2, LocalDate doseDate2) {
        this.immunizationName = immunizationName;
        this.studentId = studentId;
        this.doseId1 = doseId1;
        this.doseDate1 = doseDate1;
        this.doseId2 = doseId2;
        this.doseDate2 = doseDate2;
    }

    public Immunization(String immunizationName, int studentId, long doseId1, LocalDate doseDate1, long doseId2, LocalDate doseDate2,
                        long doseId3, LocalDate doseDate3) {
        this.immunizationName = immunizationName;
        this.studentId = studentId;
        this.doseId1 = doseId1;
        this.doseDate1 = doseDate1;
        this.doseId2 = doseId2;
        this.doseDate2 = doseDate2;
        this.doseId3 = doseId3;
        this.doseDate3 = doseDate3;
    }

    public Immunization(String immunizationName, int studentId, long doseId1, LocalDate doseDate1, long doseId2, LocalDate doseDate2,
                        long doseId3, LocalDate doseDate3, long doseId4, LocalDate doseDate4) {
        this.immunizationName = immunizationName;
        this.studentId = studentId;
        this.doseId1 = doseId1;
        this.doseDate1 = doseDate1;
        this.doseId2 = doseId2;
        this.doseDate2 = doseDate2;
        this.doseId3 = doseId3;
        this.doseDate3 = doseDate3;
        this.doseId4 = doseId4;
        this.doseDate4 = doseDate4;
    }

    public String getImmunizationName() {
        return immunizationName;
    }

    public void setImmunizationName(String immunizationName) {
        this.immunizationName = immunizationName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public long getDoseId1() {
        return doseId1;
    }

    public void setDoseId1(long doseId1) {
        this.doseId1 = doseId1;
    }

    public LocalDate getDoseDate1() {
        return doseDate1;
    }

    public void setDoseDate1(LocalDate doseDate1) {
        this.doseDate1 = doseDate1;
    }

    public long getDoseId2() {
        return doseId2;
    }

    public void setDoseId2(long doseId2) {
        this.doseId2 = doseId2;
    }

    public LocalDate getDoseDate2() {
        return doseDate2;
    }

    public void setDoseDate2(LocalDate doseDate2) {
        this.doseDate2 = doseDate2;
    }

    public long getDoseId3() {
        return doseId3;
    }

    public void setDoseId3(long doseId3) {
        this.doseId3 = doseId3;
    }

    public LocalDate getDoseDate3() {
        return doseDate3;
    }

    public void setDoseDate3(LocalDate doseDate3) {
        this.doseDate3 = doseDate3;
    }

    public long getDoseId4() {
        return doseId4;
    }

    public void setDoseId4(long doseId4) {
        this.doseId4 = doseId4;
    }

    public LocalDate getDoseDate4() {
        return doseDate4;
    }

    public void setDoseDate4(LocalDate doseDate4) {
        this.doseDate4 = doseDate4;
    }
}
