package ChessLLD;

import ChessLLD.pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currentPlayer;

    public ChessGame() {
        board=new Board();
        whitePlayer=new Player(Color.WHITE);
        blackPlayer=new Player(Color.BLACK);
        this.currentPlayer=whitePlayer;
    }

    public void start() {
        //Game loop
        while (!isGameOver()) {
            Player player=currentPlayer;
            System.out.println(player.getColor()+"s turn.");

            //Get move from the player
            Move move=getPlayerMove(player);

            //Make the move on the board
            try {
                board.movePiece(move);
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                continue;
            }

            //Switch to next player;
            switchTurn();
        }

        displayResult();
    }

    private void displayResult() {
        if (board.isCheckmate(Color.WHITE))
            System.out.println("Black wins by checkmate!");
        else if (board.isCheckmate(Color.BLACK))
            System.out.println("White wins by checkmate!");
        else if (board.isStalemate(Color.WHITE) || board.isStalemate(Color.BLACK))
            System.out.println("The game ends in a stalemate!");
    }

    private void switchTurn() {
        currentPlayer = currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
    }

    private Move getPlayerMove(Player player) {
        //Player enters the move via console input
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter source row: ");
        int sourceRow=scanner.nextInt();

        System.out.print("Enter source col: ");
        int sourceCol=scanner.nextInt();

        System.out.print("Enter destination row: ");
        int destinationRow=scanner.nextInt();

        System.out.print("Enter destination col: ");
        int destinationCol=scanner.nextInt();

        Piece piece=board.getPiece(sourceRow,sourceCol);
        if (piece==null || piece.getColor()!=player.getColor())
            throw new InvalidMoveException("Invalid piece Selection!!!");

        return new Move(board.getCell(sourceRow,sourceCol),board.getCell(destinationRow,destinationCol));
    }

    private boolean isGameOver() {
        return board.isCheckmate(Color.WHITE) ||
                board.isCheckmate(Color.BLACK) ||
                board.isStalemate(Color.WHITE) ||
                board.isCheckmate(Color.BLACK);
    }


}
