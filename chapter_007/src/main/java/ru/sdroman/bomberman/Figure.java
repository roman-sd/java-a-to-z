package ru.sdroman.bomberman;

import java.util.concurrent.TimeUnit;

/**
 * @author sdroman
 * @since 09.2017
 */
public class Figure {

    /**
     * Board.
     */
    private final Board board;
    /**
     * Position.
     */
    private Position position;

    /**
     * Constructs a new Figure object.
     *
     * @param board Board
     */
    public Figure(final Board board) {
        this.board = board;
    }

    /**
     * Returns position.
     *
     * @return Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position Position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Returns board.
     *
     * @return Board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Returns next step.
     *
     * @param pos Position
     * @return true, if next position is unlock
     */
    public boolean nextStep(final Position pos) {
        boolean isDone = false;
        Cell cell = this.getBoard().getCell(pos);
        try {
            if (cell != null && cell.getLock().tryLock(500, TimeUnit.MILLISECONDS)) {
                Cell oldCell = this.getBoard().getCell(this.position);
                this.setPosition(pos);
                oldCell.getLock().unlock();
                isDone = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isDone;
    }

    /**
     * Sets start position.
     *
     * @param pos Position
     */
    public void setStartPosition(Position pos) {
        Cell cell = this.getBoard().getCell(pos);
        if (cell.getLock().tryLock()) {
            this.setPosition(pos);
        }
    }
}
