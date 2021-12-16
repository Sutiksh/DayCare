package edu.neu.csye6200.model.enums;

public enum ClassroomType {
    SixToTwelve(6,12,3),
    ThirteenToTwentyFour(13, 24, 3),
    TwentyFiveToThirtyFive(25, 35, 3),
    ThirtySixToFortySeven(26, 47, 3),
    FortyEightToFiftyNine(48, 59, 2),
    SixtyAndUp(60, 100, 2);

    private final int minAge;
    private final int maxAge;
    private final int maxGroupPerClass;

    ClassroomType(int minAge, int maxAge, int maxGroupPerClass) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.maxGroupPerClass = maxGroupPerClass;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public int getMaxGroupPerClass() {
        return maxGroupPerClass;
    }
}
