package edu.neu.csye6200.model.enums;

public enum GroupType {

    SixToTwelve(6,12,4),
    ThirteenToTwentyFour(13, 24, 5),
    TwentyFiveToThirtyFive(25, 35, 6),
    ThirtySixToFortySeven(26, 47, 8),
    fortyEightToFiftyNine(48, 59, 12),
    sixtyAndUp(60, 100, 15);

    private final int minAge;
    private final int maxAge;
    private final int maxStudentPerGroup;

    GroupType(int minAge, int maxAge, int maxGroupPerClass) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.maxStudentPerGroup = maxGroupPerClass;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public int getMaxStudentPerGroup() {
        return maxStudentPerGroup;
    }
}
