package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Cell;
import ChessLLD.Color;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Cell from, Cell to) {
        int rowDiff=(to.getRow()-from.getRow());
        int colDiff=(to.getCol()-from.getCol());

        return (rowDiff==colDiff);
    }
}
