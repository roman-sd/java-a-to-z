package ru.sdroman.TicTacToe.input;

/**
 * Class ValidateInput.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class ValidateInput {

    /**
     * x.
     */
    private String x;

    /**
     * y.
     */
    private String y;

    /**
     * Constructs new ValidateInput object.
     *
     * @param msg String
     */
    public ValidateInput(String msg) {
        String[] res = msg.trim().split("\\s+");
        int count = 0;
        this.x = res[count++];
        this.y = res.length > 1 ? res[count] : "";
    }

    /**
     * Gets x.
     *
     * @return int
     */
    public int getX() {
        return Integer.valueOf(this.x);
    }

    /**
     * Gets y.
     *
     * @return int
     */
    public int getY() {
        return Integer.valueOf(this.y);
    }
}
