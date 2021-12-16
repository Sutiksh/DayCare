package edu.neu.csye6200.api.abstractClass;

import edu.neu.csye6200.model.Immunization;

import java.util.Date;

public abstract class AbstractImmunization {

    public abstract void setImmunizationDate(Date immunizationDate);

    public abstract void addImmunization(Immunization imm);

    public abstract void updateImmunization(Immunization imm);

    public abstract void deleteImmunization(Immunization imm);

    public abstract void deleteImmunization(long immunizationId);

}
