package ru.sdroman.bomberman;

/**
 * @author sdroman
 * @since 09.2017
 */
public class Monster extends Figure implements Runnable {

    /**
     * Start position.
     */
    private final Position start = new Position(0, 0);

    /**
     * Monster.
     */
    private MonsterLogic logic = new MonsterLogic();

    /**
     * Constructs a new Figure object.
     *
     * @param board Board
     */
    public Monster(Board board) {
        super(board);
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
        setStartPosition(start);
        while (true) {
            System.out.println("Monster: " + this.getPosition().getX() + "  " + this.getPosition().getY());
            Position nextPosition = this.logic.nextPosition(this.getBoard(), this.getPosition());
            if (this.nextStep(nextPosition)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.logic.changeDirection();
            }
        }
    }
}
