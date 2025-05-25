package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Cell;
import ChessLLD.Color;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Cell from, Cell to) {
        int rowDiff=Math.abs(to.getRow()-from.getRow());
        int colDiff=Math.abs(to.getCol()-from.getCol());

        return (rowDiff==0 || colDiff==0 || rowDiff==colDiff);
    }
}
