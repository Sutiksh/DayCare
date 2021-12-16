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