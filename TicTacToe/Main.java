package TicTacToe;

public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        String winner=game.startGame();
        
        System.out.println("The winner is: "+winner);
    }
}
