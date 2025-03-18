package SnakeAndLadder;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int totalDice;
    int minVal=1;
    int maxVal=6;

    Dice(int totalDice) {
        this.totalDice=totalDice;
    }

    int roll() {
        int diceUsed=0;
        int totalScore=0;

        while (diceUsed<totalDice) {
            int newScore=ThreadLocalRandom.current().nextInt(minVal,maxVal+1);
            totalScore+=newScore;

            diceUsed++;
        }

        return totalScore;
    }
}
