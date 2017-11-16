package ru.sdroman.aquarium;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Aquarium {

    /**
     * Number fishes.
     */
    private static final int FISHES = 50;

    /**
     * Aquarium size.
     */
    private static final int MAXSIZE_X = 600;

    /**
     * Aquarium size.
     */
    private static final int MAXSIZE_Y = 400;

    /**
     * Aquarium cells.
     */
    private Cell[][] cells = new Cell[MAXSIZE_X][MAXSIZE_Y];

    /**
     * Constructs a new Aquarium object.
     */
    public Aquarium() {
        loadCells();
        start();
    }

    /**
     * Initialization cells.
     */
    private void loadCells() {
        for (int i = 0; i < MAXSIZE_X; i++) {
            for (int j = 0; j < MAXSIZE_Y; j++) {
                this.cells[i][j] = new Cell(-1, new Position(i, j), new ReentrantLock());
            }
        }
    }

    /**
     * Start.
     */
    private void start() {
        Fish fish;
        for (int i = 0; i < FISHES; i++) {
            fish = new Fish(1, i + 1, this.cells);
            Thread thread = new Thread(fish, "Fish " + (i + 1));
            thread.start();
        }
    }

    /**
     * Main.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        new Aquarium();
    }
}
