package ru.sdroman.bomberman;

/**
 * @author sdroman
 * @since 09.2017
 */
public class Hero extends Figure implements Runnable {

    /**
     * Start position.
     */
    private final Position STARTPOSITION = new Position(0, 0);

    /**
     * Input.
     */
    private Input input;

    /**
     * Constructs a new Hero object.
     * @param board Board
     * @param input Input
     */
    public Hero(Board board, Input input) {
        super(board);
        this.input = input;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        setStartPosition(STARTPOSITION);

        while (true) {
            Position pos = this.input.read();
            Cell cell = nextStep(pos);
            System.out.println(this.getPosition().getX() + "    " + this.getPosition().getY());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Sets start position
     * @param pos Position
     */
    private void setStartPosition(Position pos) {
        Cell cell = this.getBoard().getCell(pos);
        if (cell.getLock().tryLock()) {
            this.setPosition(pos);
        }
    }
}
