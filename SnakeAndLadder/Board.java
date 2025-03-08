package SnakeAndLadder;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    Board(int size,int snakes,int ladders) {
        cells=new Cell[size][size];
        
        InitializeBoard();
        addSankesAndLadders(snakes,ladders);
    }

    void InitializeBoard() {
        for (int i=0;i<cells.length;i++)
            for (int j=0;j<cells.length;j++)
                cells[i][j]=new Cell();
    }

    void addSankesAndLadders(int snakesCnt,int laddersCnt) {
        while (snakesCnt > 0) {
            int snakeHead=ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail=ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

            if (snakeHead<=snakeTail)
                continue;

            Jump snakeObj=new Jump();
            snakeObj.start=snakeHead;
            snakeObj.end=snakeTail;

            Cell cell=getCell(snakeHead);
            cell.jump=snakeObj;

            snakesCnt--;
        }

        while (laddersCnt > 0) {
            int ladderStart=ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd=ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

            if (ladderStart>=ladderEnd)
                continue;

            Jump ladderObj=new Jump();
            ladderObj.start=ladderStart;
            ladderObj.end=ladderEnd;

            Cell cell=getCell(ladderStart);
            cell.jump=ladderObj;

            laddersCnt--;
        }
    }

    Cell getCell(int playerPositon) {
        int boardRow=playerPositon/cells.length;
        int boardCol=playerPositon%cells.length;
        return cells[boardRow][boardCol];
    }
}
