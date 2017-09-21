package ru.sdroman.bomberman;

/**
 * @author sdroman
 * @since 09.2017
 */
public class MonsterLogic {

    /**
     * Direction.
     */
    private int direction;

    /**
     * Changes direction.
     */
    public void changeDirection() {
        final int oldDirection = this.direction;
        do {
            this.direction = (int) (Math.random() * 4);
        } while (oldDirection == this.direction);
    }

    /**
     * Checks position.
     *
     * @param board    Board
     * @param position Position
     * @return true, if position is on board.
     */
    private boolean testStep(Board board, Position position) {
        boolean isDone;
        int x = position.getX();
        int y = position.getY();
        switch (this.direction) {
            case 0:
                isDone = board.isOnBoard(x + 1, y);
                break;
            case 1:
                isDone = board.isOnBoard(x, y - 1);
                break;
            case 2:
                isDone = board.isOnBoard(x - 1, y);
                break;
            case 3:
                isDone = board.isOnBoard(x, y + 1);
                break;
            default:
                isDone = false;
        }
        return isDone;
    }

    /**
     * Returns next position.
     *
     * @param board    board
     * @param position current position
     * @return next position
     */
    public Position nextPosition(Board board, Position position) {
        boolean isDone = false;
        int x = position.getX();
        int y = position.getY();
        Position newPosition = null;
        while (!isDone) {
            switch (this.direction) {
                case 0:
                    if (testStep(board, position)) {
                        newPosition = new Position(x + 1, y);
                        isDone = true;
                    } else {
                        changeDirection();
                    }
                    break;
                case 1:
                    if (testStep(board, position)) {
                        newPosition = new Position(x, y - 1);
                        isDone = true;
                    } else {
                        changeDirection();
                    }
                    break;
                case 2:
                    if (testStep(board, position)) {
                        newPosition = new Position(x - 1, y);
                        isDone = true;
                    } else {
                        changeDirection();
                    }
                    break;
                case 3:
                    if (testStep(board, position)) {
                        newPosition = new Position(x, y + 1);
                        isDone = true;
                    } else {
                        changeDirection();
                    }
                    break;
                default:
                    isDone = false;
            }
        }
        return newPosition;
    }
}
