package edu.neu.csye6200.model;

import edu.neu.csye6200.model.enums.StatusType;
import edu.neu.csye6200.model.enums.VaccinationType;

public class Immunization {

    private long immunizationId;
    private VaccinationType immunizationName;
    private long studentId;
    private int totalDoses;
    private int dosesTaken;
    private StatusType vaccinationStatusType;
    private String recentVaccineDate;
    private String nextVaccineDate;

    public Immunization(long immunizationId, VaccinationType immunizationName, long studentId, int totalDoses, int dosesTaken,
                        StatusType vaccinationStatusType, String recentVaccineDate, String nextVaccineDate) {
        this.immunizationId = immunizationId;
        this.immunizationName = immunizationName;
        this.studentId = studentId;
        this.totalDoses = totalDoses;
        this.dosesTaken = dosesTaken;
        this.vaccinationStatusType = vaccinationStatusType;
        this.recentVaccineDate = recentVaccineDate;
        this.nextVaccineDate = nextVaccineDate;
    }

    public Immunization() {    }

    public int getTotalDoses() {
        return totalDoses;
    }

    public void setTotalDoses(int totalDoses) {
        this.totalDoses = totalDoses;
    }

    public int getDosesTaken() {
        return dosesTaken;
    }

    public void setDosesTaken(int dosesTaken) {
        this.dosesTaken = dosesTaken;
    }

    public StatusType getVaccinationStatus() {
        return vaccinationStatusType;
    }

    public void setVaccinationStatus(StatusType vaccinationStatusType) {
        this.vaccinationStatusType = vaccinationStatusType;
    }

    public String getRecentVaccineDate() {
        return recentVaccineDate;
    }

    public void setRecentVaccineDate(String recentVaccineDate) {
        this.recentVaccineDate = recentVaccineDate;
    }

    public String getNextVaccineDate() {
        return nextVaccineDate;
    }

    public void setNextVaccineDate(String nextVaccineDate) {
        this.nextVaccineDate = nextVaccineDate;
    }

    public long getImmunizationId() {
        return immunizationId;
    }

    public void setImmunizationId(long immunizationId) {
        this.immunizationId = immunizationId;
    }

    public VaccinationType getImmunizationName() {
        return immunizationName;
    }

    public void setImmunizationName(VaccinationType immunizationName) {
        this.immunizationName = immunizationName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
