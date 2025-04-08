package LowLevelDesign.CricbuzzLLD.Inning;

import LowLevelDesign.CricbuzzLLD.MatchType;
import LowLevelDesign.CricbuzzLLD.Team.Team;

public class InningDetails {
    public Team battingTeam;
    public Team bowlingTeam;
    MatchType matchType;
    List<OverDetails> overs;
}
