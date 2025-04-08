package LowLevelDesign.CricbuzzLLD.Team;

import LowLevelDesign.CricbuzzLLD.Team.Player.PlayerDetails;
import LowLevelDesign.CricbuzzLLD.Team.Player.PlayerBattingController;
import LowLevelDesign.CricbuzzLLD.Team.Player.PlayerBowlingController;

import java.util.*;

public class Team {
    public String teamName;
    public Queue<PlayerDetails> playing11;
    public List<PlayerDetails> bench;
    public PlayerBattingController battingController;
    public PlayerBowlingController bowlingController;
    public boolean isWinner;


}
