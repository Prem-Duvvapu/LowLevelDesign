package ChessLLD.pieces;

import ChessLLD.Board;
import ChessLLD.Cell;
import ChessLLD.Color;

public abstract class Piece {
    protected final Color color;

    public Piece(Color color) {
        this.color=color;
    }

    public abstract boolean isValidMove(Board board, Cell from, Cell to);

    public Color getColor() {
        return color;
    }
}
