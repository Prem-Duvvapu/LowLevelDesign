package TicTacToe;
import java.util.*;

public class Board {
    int size;
    PlayingPiece[][] board;

    Board(int size) {
        this.size=size;
        board=new PlayingPiece[size][size];
    }

    public boolean addPiece(int row,int col,PlayingPiece playingPiece) {
        if (board[row][col]!=null)
            return false;

        board[row][col]=playingPiece;
        return true;
    }

    public List<Pair> getFreeCells() {
        List<Pair> freeCellsList=new ArrayList<>();

        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                if (board[i][j]==null)
                    freeCellsList.add(new Pair(i,j));
            }
        }

        return freeCellsList;        
    }

    public void printBoard() {
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                if (board[i][j]!=null)
                    System.out.println(board[i][j].pieceType + "  ");
                else
                    System.out.println("   ");
                
                System.out.println("|");
            }
            System.out.println();
        }
    }
}
