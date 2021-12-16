package edu.neu.csye6200.api;

import edu.neu.csye6200.api.abstractClass.AbstractImmunization;
import edu.neu.csye6200.dao.ImmunizationDao;
import edu.neu.csye6200.model.Immunization;

import java.util.Date;

public class ImmunizationApi extends AbstractImmunization {
    private final ImmunizationDao dao = new ImmunizationDao();

    @Override
    public void setImmunizationDate(Date immunizationDate) {
    }

    @Override
    public void addImmunization(Immunization imm) {
        dao.addImmunization(imm);
    }

    @Override
    public void updateImmunization(Immunization imm) {
        dao.updateImmunization(imm);
    }

    @Override
    public void deleteImmunization(Immunization imm) {
        dao.deleteImmunization(imm);
    }

    @Override
    public void deleteImmunization(long immunizationId) {
        dao.deleteImmunization(immunizationId);
    }
}
