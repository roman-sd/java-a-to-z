package ru.sdroman.aquariumtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Aquarium {

    /**
     * Fish's list.
     */
    private List<Fish> fishList;

    /**
     * Number fish.
     */
    private int numberFish;

    /**
     * Constructs a new Aquarium object.
     * @param numberFish int
     */
    public Aquarium(int numberFish) {
        this.numberFish = numberFish;
        this.fishList = new ArrayList<>();
        loadsFishes();
    }

    /**
     * Constructs a fish's list.
     */
    private void loadsFishes() {
        for (int i = 0; i < this.numberFish; i++) {
            this.fishList.add(new Fish(1, 1));
        }
    }

    /**
     * Run.
     */
    public void run() {
        final int sleepTime = 500;
        while (true) {
            for (Fish fish : fishList) {
                fish.swim();
                fish.showFish();

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Main.
     * @param args String[]
     */
    public static void main(String[] args) {
        new Aquarium(1).run();
    }
}
