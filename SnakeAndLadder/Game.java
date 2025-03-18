package SnakeAndLadder;
import java.util.*;

public class Game {
    Deque<Player> players;
    Player winner;
    Board board;
    Dice dice;

    Game() {
        InitializeGame();
    }

    void InitializeGame() {
        board=new Board(10,5,5);
        winner=null;
        players=new LinkedList<>();
        dice=new Dice(1);

        addPlayers();
    }

    void addPlayers() {
        Player p1=new Player(1, 0);
        Player p2=new Player(2, 0);

        players.add(p1);
        players.add(p2);
    }

    void startGame() {
        while (winner==null) {
            Player playerTurn=findPlayerTurn();
            
            int playerTurnPositon=playerTurn.currentPositon;
            System.out.println("Current player is: "+playerTurn.id+" and current position is: "+playerTurn.currentPositon);

            int score=dice.roll();
            System.out.println(score);

            int newPosition=playerTurnPositon+score;
            newPosition=checkJump(newPosition);
            playerTurn.currentPositon=newPosition;

            System.out.println("Current player is: "+playerTurn.id+" and new position is: "+playerTurn.currentPositon);

            if (newPosition==board.cells.length*board.cells.length-1) {
                winner=playerTurn;
            }
        }

        System.out.println("Player "+winner.id+" won the game");
    }

    Player findPlayerTurn() {
        Player playerTurn=players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    int checkJump(int position) {
        if (position > board.cells.length*board.cells.length-1)
            return position;

        Cell cell=board.getCell(position);
        if (cell.jump!=null) {
            String jumpBy=(cell.jump.start<cell.jump.end) ? "Ladder" : "Snake";
            System.out.println("The new position is because of "+jumpBy);
            return cell.jump.end;
        }

        return position;
    }
}
