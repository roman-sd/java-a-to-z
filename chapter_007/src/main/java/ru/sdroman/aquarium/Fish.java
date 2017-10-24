package ru.sdroman.aquarium;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Fish {

    /**
     * Time of death.
     */
    private long deadTime;

    /**
     * Number.
     */
    private int num;

    /**
     * Gender.
     */
    private int gender;

    /**
     * Constructs new Fish object.
     *
     * @param num      int
     * @param deadTime long
     * @param gender   int
     */
    public Fish(int num, long deadTime, int gender) {
        this.deadTime = deadTime;
        this.num = num;
        this.gender = gender;
    }

    /**
     * Return number.
     *
     * @return int
     */
    public int getNum() {
        return num;
    }

    /**
     * Return deadTime.
     *
     * @return int
     */
    public long getDeadTime() {
        return deadTime;
    }

    /**
     * Return gender.
     *
     * @return String
     */
    public String getGender() {
        return gender == 1 ? "male" : "female";
    }
}
