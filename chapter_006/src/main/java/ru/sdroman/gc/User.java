package ru.sdroman.gc;

/**
 * @author sdroman
 * @since 11.2017
 */
public class User {

    /**
     * Sleep time.
     */
    private static final int SLEEPTIME = 100;

    /**
     * Name.
     */
    private String name;

    /**
     * Number.
     */
    private int num;

    /**
     * Constructs a new User object.
     * @param name String
     * @param num int
     */
    public User(String name, int num) {
        this.name = name;
        this.num = num;
    }

    /**
     * ToString.
     * @return String
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + num +
                '}';
    }

    /**
     * Finalize.
     * @throws Throwable exception
     */
    @Override
    public void finalize() throws Throwable {
        System.out.println(String.format("finalize %s", this));
        super.finalize();
    }

    /**
     * Info.
     */
    public static void info() {
        Runtime runtime = Runtime.getRuntime();
        final int mb = 1024 * 1024;

        System.out.println(String.format("Total: %s",  runtime.totalMemory() / mb));
        System.out.println(String.format("Free: %s", runtime.freeMemory() / mb));
        System.out.println(String.format("Max: %s", runtime.maxMemory() / mb));
    }

    /**
     * Main.
     * @param args String[]
     */
    public static void main(String[] args) {
        System.out.println("start");
        User user = new User("user", 0);
        info();
        System.out.println(user);
        user = null;
        System.gc();
        info();

        try {
            Thread.sleep(SLEEPTIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
