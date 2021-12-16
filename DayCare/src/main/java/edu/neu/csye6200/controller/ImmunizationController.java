package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.ImmunizationApi;
import edu.neu.csye6200.model.Immunization;

import java.util.Date;

public class ImmunizationController {

    private ImmunizationApi api = new ImmunizationApi();

    public void setImmunizationDate(Date immunizationDate) {
        api.setImmunizationDate(immunizationDate);
    }

    public void addImmunizationRecord(Immunization imm) {
        api.addImmunization(imm);
    }

}
