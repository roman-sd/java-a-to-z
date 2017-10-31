package ru.sdroman.aquariumtest;

import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Fish {

    /**
     * Max velocity.
     */
    private final static int MAX_VELOCITY = 6;

    /**
     * Max x.
     */
    private final static int MAX_X = 600;

    /**
     * Max y.
     */
    private final static int MAX_Y = 400;

    /**
     * Location.
     */
    private Position position;

    /**
     * Velocity.
     */
    private Position velocity;

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
     * @param gender int
     * @param id int
     */
    public Fish(int gender, int id) {
        this.gender = gender;
        this.id = id;
        setStartPosition();
        setStartVelocity();
    }

    /**
     * Returns position.
     * @return Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns gender.
     * @return int
     */
    public int getGender() {
        return gender;
    }

    /**
     * Returns id.
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
        int x = abs(this.random.nextInt() % MAX_X);
        int y = abs(this.random.nextInt() % MAX_Y);
        this.position = new Position(x, y);
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
     * Swimming.
     */
    public void swim() {
        changeVelocity();
        this.position.setX(this.position.getX() + this.velocity.getX());
        this.position.setY(this.position.getY() + this.velocity.getY());
        checkPosition();
    }

    /**
     * Checks location.
     */
    private void checkPosition() {
        if (this.position.getX() >= MAX_X) {
            this.position.setX(MAX_X);
            this.velocity.setX(-this.velocity.getX());
        }

        if (this.position.getX() <= 0) {
            this.position.setX(0);
            this.velocity.setX(-this.velocity.getX());
        }
        if (this.position.getY() >= MAX_Y) {
            this.position.setY(MAX_Y);
            this.velocity.setY(-this.velocity.getY());

        }
        if (this.position.getY() <= 0) {
            this.position.setX(0);
            this.velocity.setY(-this.velocity.getY());
        }
    }

    /**
     * Shows fish's location.
     */
    public void showFish() {
        System.out.println(this.position.toString());
    }
}
