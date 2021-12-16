package edu.neu.csye6200.dao;

import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.utils.DatabaseUtil;

public class ImmunizationDao {

    public void addImmunization(Immunization imm) {
        String sql = "INSERT into IMMUNIZATION(immunization_name, student_id, recent_dose_date, next_dose_date, " +
                "vaccination_status, doses_taken, total_doses) " +
                "VALUES("+imm.getImmunizationName()
                +"','"+imm.getStudentId()
                +"','"+imm.getRecentVaccineDate()
                +"','"+imm.getNextVaccineDate()
                +"','"+imm.getVaccinationStatus()
                +"','"+imm.getDosesTaken()
                +"','"+imm.getTotalDoses()+"');";
        DatabaseUtil.executeSQL(sql);
    }

    public void updateImmunization(Immunization imm) {
        String sql = "UPDATE immunization " + "SET immunization_name = '" + imm.getImmunizationName()
                + "', student_id = '" + imm.getStudentId()
                + "', recent_dose_date = '" + imm.getRecentVaccineDate()
                + "', next_dose_date = '" + imm.getNextVaccineDate()
                + "', vaccination_status = '" + imm.getVaccinationStatus()
                + "', doses_taken = '" + imm.getDosesTaken()
                + "', total_doses = '" + imm.getTotalDoses()
                + " WHERE immunization_id = " + imm.getImmunizationId() + ";";
        DatabaseUtil.executeSQL(sql);
    }

    public void deleteImmunization(Immunization imm) {
        DatabaseUtil.deleteRecord("immunization", "immunization_id", String.valueOf(imm.getImmunizationId()));
    }

    public void deleteImmunization(long immunizationId) {
        DatabaseUtil.deleteRecord("immunization", "immunization_id", String.valueOf(immunizationId));
    }
}
