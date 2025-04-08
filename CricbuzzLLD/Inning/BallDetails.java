package LowLevelDesign.CricbuzzLLD.Inning;

import LowLevelDesign.CricbuzzLLD.Team.Wicket;
import LowLevelDesign.CricbuzzLLD.Team.Player.PlayerDetails;

public class BallDetails {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public PlayerDetails playedBy;
    public PlayerDetails bowledBy;
    public Wicket wicket;
    List<ScoreUpdateObserver> scoreUpdateObserverList=new ArrayList<>();
    
}
