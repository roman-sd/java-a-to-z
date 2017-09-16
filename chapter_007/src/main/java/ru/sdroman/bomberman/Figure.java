package ru.sdroman.bomberman;

/**
 * @author sdroman
 * @since 09.2017
 */
public class Figure {

    /**
     * Position.
     */
    private Position position;

    /**
     * Board.
     */
    private final Board board;

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
     * @return Cell
     */
    public Cell nextStep(final Position pos) {
        Cell cell = this.getBoard().getCell(pos);
        if (cell != null && cell.getLock().tryLock()) {
            Cell oldCell = this.getBoard().getCell(this.position);
            this.setPosition(pos);
            oldCell.getLock().unlock();
        }
        return cell;
    }
}
