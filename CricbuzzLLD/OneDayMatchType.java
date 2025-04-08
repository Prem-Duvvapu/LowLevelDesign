package LowLevelDesign.CricbuzzLLD;

public class OneDayMatchType implements MatchType {
    @Override
    public int noOfOvers() {
        return 50;
    }

    @Override
    public int maxBowlerOversLimit() {
        return 10;
    }
}
