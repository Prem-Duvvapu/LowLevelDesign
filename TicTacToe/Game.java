package TicTacToe;
import java.util.*;

public class Game {
    Board board;
    Deque<Player> playersList;

    Game() {
        board=new Board(3);
        playersList=new ArrayDeque<>();

        initializeGame();
    }

    public void initializeGame() {
        PlayingPieceX playingPieceX=new PlayingPieceX();
        Player player1=new Player("Prem",playingPieceX);

        PlayingPieceO playingPieceO=new PlayingPieceO();
        Player player2=new Player("Sai", playingPieceO);

        playersList.add(player1);
        playersList.add(player2);
    }

    public String startGame() {
        boolean winner=false;

        while (!winner) {
            Player currentPlayer=playersList.removeFirst();

            //print the board
            board.printBoard();

            //check if there are free cells or not
            List<Pair> freeCellsList=board.getFreeCells();
            if (freeCellsList.isEmpty()) {
                break;
            }

            System.out.println("Current player is: "+currentPlayer.name+". Enter the row, col: ");
            Scanner sc=new Scanner(System.in);
            String[] input=sc.nextLine().split(",");
            int row=Integer.parseInt(input[0]);
            int col=Integer.parseInt(input[1]);

            boolean addingPiece=board.addPiece(row, col, currentPlayer.playingPiece);
            if (!addingPiece) {
                System.out.println("Incorrect positon chosen. Try again...");
                playersList.addFirst(currentPlayer);
                continue;
            }

            playersList.addLast(currentPlayer);;
            winner=checkIsWinnerPossible(row,col,currentPlayer.playingPiece);

            if (winner) {
                board.printBoard();
                return currentPlayer.name;
            }
        }

        return "tie";
    }

    public boolean checkIsWinnerPossible(int row,int col,PlayingPiece playingPiece) {
        boolean rowCheck=true;
        boolean colCheck=true;
        boolean diagCheck=true;
        boolean antiDiagCheck=true;

        //row check
        for (int j=0;j<board.size;j++) {
            if (board.board[row][j]==null || board.board[row][j]!=playingPiece) {
                rowCheck=false;
                break;
            }
        }

        //col check
        for (int i=0;i<board.size;i++) {
            if (board.board[i][col]==null || board.board[i][col]!=playingPiece) {
                colCheck=false;
                break;
            }
        }

        //diagonal check
        for (int i=0;i<board.size;i++) {
            if (board.board[i][i]==null || board.board[i][i]!=playingPiece) {
                diagCheck=false;
                break;
            }
        }

        //anti diagonal check
        for (int i=0,j=board.size-1;i<board.size && j>=0;i++,j--) {
            if (board.board[i][j]==null || board.board[i][j]!=playingPiece) {
                antiDiagCheck=false;
                break;
            }
        }

        return (rowCheck || colCheck || diagCheck || antiDiagCheck);
    }
}
