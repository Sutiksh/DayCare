package edu.neu.csye6200.model.enums;

public enum VaccinationType {
    HepatitisB(3),
    DTAP(4),
    Polio(3),
    MMR(1),
    Varicella(1),
    Hib(4);

    private final int doses;

    VaccinationType(int doses) {
        this.doses = doses;
    }

    public int getDoses() {
        return doses;
    }
}
