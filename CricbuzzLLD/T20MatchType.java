package LowLevelDesign.CricbuzzLLD;

public class T20MatchType implements MatchType {
    @Override
    public int noOfOvers() {
        return 20;
    }

    @Override
    public int maxBowlerOversLimit() {
        return 4;
    }
}
