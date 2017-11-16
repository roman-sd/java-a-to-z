package ru.sdroman.aquarium;

import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Fish implements Runnable {

    /**
     * Max velocity.
     */
    private static final int MAX_VELOCITY = 6;

    /**
     * Sleep time.
     */
    private static final long SLEEPTIME = 500;

    /**
     * Max x.
     */
    private final int maxX;

    /**
     * Max y.
     */
    private final int maxY;

    /**
     * Location.
     */
    private Position position;

    /**
     * Velocity.
     */
    private Position velocity;

    /**
     * Cells.
     */
    private Cell[][] cells;

    /**
     * Gender.
     */
    private int gender;

    /**
     * Id.
     */
    private int id;

    /**
     * Random.
     */
    private Random random = new Random(System.currentTimeMillis());

    /**
     * Constructs a new Fish object.
     *
     * @param gender int
     * @param id     int
     * @param cells Cell[][]
     */
    public Fish(int gender, int id, Cell[][] cells) {
        this.gender = gender;
        this.id = id;
        this.cells = cells;
        maxX = cells.length - 1;
        maxY = cells[0].length - 1;
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
     * Returns gender.
     *
     * @return int
     */
    public int getGender() {
        return gender;
    }

    /**
     * Returns id.
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets velocity.
     */
    private void setStartVelocity() {
        int x = this.random.nextInt() % MAX_VELOCITY;
        int y = this.random.nextInt() % MAX_VELOCITY;
        this.velocity = new Position(x, y);
    }

    /**
     * Sets start location.
     */
    private void setStartPosition() {
        int x = abs(this.random.nextInt() % this.maxX);
        int y = abs(this.random.nextInt() % this.maxY);
        this.position = new Position(x, y);
        this.cells[x][y].getLock().lock();
        this.cells[x][y].setFishId(this.id);
    }

    /**
     * Start thread.
     */
    @Override
    public void run() {
        setStartVelocity();
        setStartPosition();
        while (!Thread.currentThread().isInterrupted()) {
            int oldX = this.position.getX();
            int oldY = this.position.getY();
            this.swim();

            int x = this.position.getX();
            int y = this.position.getY();
            System.out.println(String.format("%7s%s%4s%4s", Thread.currentThread().getName(), ":", x, y));

            if (cells[x][y].getLock().isLocked() && x != oldX && y != oldY) {
                System.out.println(String.format(
                        "%s%3s%2s%3s%4s", "fishes №№", this.getId(), "&", this.cells[x][y].getFishId(), "met"));
                this.position.setX(oldX);
                this.position.setY(oldY);
            } else {
                this.cells[x][y].getLock().lock();
                this.cells[x][y].setFishId(this.id);
                this.cells[oldX][oldY].setFishId(-1);
                this.cells[oldX][oldY].getLock().unlock();
            }
            sleep(SLEEPTIME);
        }
    }

    /**
     * Changes velocity.
     */
    private void changeVelocity() {
        this.velocity.setX(this.velocity.getX() + this.random.nextInt() % MAX_VELOCITY);
        this.velocity.setX(min(this.velocity.getX(), MAX_VELOCITY));
        this.velocity.setX(max(this.velocity.getX(), -MAX_VELOCITY));

        this.velocity.setY(this.velocity.getY() + this.random.nextInt() % MAX_VELOCITY);
        this.velocity.setY(min(this.velocity.getY(), MAX_VELOCITY));
        this.velocity.setY(max(this.velocity.getY(), -MAX_VELOCITY));
    }

    /**
     * Sleep.
     *
     * @param sleepTime long
     */
    private void sleep(final long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Swimming.
     */
    public void swim() {
        this.changeVelocity();
        this.changePosition();
    }

    /**
     * Checks location.
     */
    private void changePosition() {
        this.position.setX(this.position.getX() + this.velocity.getX());
        this.position.setY(this.position.getY() + this.velocity.getY());

        if (this.position.getX() >= maxX) {
            this.position.setX(maxX);
            this.velocity.setX(-this.velocity.getX());
        }
        if (this.position.getX() <= 0) {
            this.position.setX(0);
            this.velocity.setX(-this.velocity.getX());
        }
        if (this.position.getY() >= maxY) {
            this.position.setY(maxY);
            this.velocity.setY(-this.velocity.getY());
        }
        if (this.position.getY() <= 0) {
            this.position.setY(0);
            this.velocity.setY(-this.velocity.getY());
        }
    }
}
