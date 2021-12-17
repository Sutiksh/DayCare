package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.ImmunizationApi;
import edu.neu.csye6200.api.concrete.ConcreteImmunizationApi;
import edu.neu.csye6200.model.Immunization;

import java.util.Date;
import java.util.List;

public class ImmunizationController {
    private final ImmunizationApi api = new ConcreteImmunizationApi();

    public List<Immunization> getAllImmunization() {
        return api.getAllImmunization();
    }

    public List<Immunization> getImmunizationByName(String immName) {
        return api.getImmunizationByName(immName);
    }

    public List<Immunization> getImmunizationByNameAndId(String immName,
                                                  long studentId){
        return api.getImmunizationByNameAndId(immName, studentId);
    }

    public List<Immunization> getImmunizationByIdDao(long studentId){
        return api.getImmunizationByIdDao(studentId);
    }

    public void addImmunization(Immunization imm) {
        api.addImmunization(imm);
    }

    public void updateImmunization(Immunization imm) {
        api.updateImmunization(imm);
    }

    public void deleteImmunization(Immunization imm) {
        api.deleteImmunization(imm);
    }
}
