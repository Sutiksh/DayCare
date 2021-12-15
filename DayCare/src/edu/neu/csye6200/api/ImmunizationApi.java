package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Immunization;

import java.util.List;

public interface ImmunizationApi {
    List<Immunization> getAllImmunization();

    List<Immunization> getImmunizationByName(String immName);

    void addImmunization(Immunization imm);

    void updateImmunization(Immunization imm);

    void deleteImmunization(Immunization imm);
}
