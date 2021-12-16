package edu.neu.csye6200.api.concrete;

import edu.neu.csye6200.api.ImmunizationApi;
import edu.neu.csye6200.dao.ImmunizationDao;
import edu.neu.csye6200.model.Immunization;

import java.util.List;

public class ConcreteImmunizationApi implements ImmunizationApi {
    @Override
    public int getNumOfImmunization() {
        return ImmunizationDao.getNumOfImmunizationDao();
    }

    @Override
    public List<Immunization> getAllImmunization() {
        return ImmunizationDao.getAllImmunizationDao();
    }

    @Override
    public List<Immunization> getImmunizationByName(String immName) {
        return ImmunizationDao.getImmunizationByNameDao(immName);
    }

    @Override
    public void addImmunization(Immunization imm) {
        ImmunizationDao.addImmunizationDao(imm);
    }

    @Override
    public void updateImmunization(Immunization imm) {
        ImmunizationDao.updateImmunizationDao(imm);
    }

    @Override
    public void deleteImmunization(Immunization imm) {
        ImmunizationDao.deleteImmunizationDao(imm);
    }
}
