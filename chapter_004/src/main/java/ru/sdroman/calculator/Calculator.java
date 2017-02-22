package ru.sdroman.calculator;

/**
 * Class Calculator.
 *
 * @author sdroman
 * @version 0.1
 * @since 02.17
 */
public class Calculator {

    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * Array of actions.
     */
    private Action[] actions = new Action[DEFAULT_CAPACITY];

    /**
     * Result.
     */
    private int result;

    /**
     * Constructs new Calculator object.
     */
    public Calculator() {
        fillActions();
    }

    /**
     * Fill array of actions.
     */
    private void fillActions() {
        int count = 0;
        actions[count++] = new Add();
        actions[count++] = new Div();
        actions[count++] = new Multiple();
        actions[count] = new Subtraction();
    }

    /**
     * Select operations.
     *
     * @param operation String
     * @param first     int
     * @param second    int
     */
    public void selectOperation(String operation, int first, int second) {
        boolean done = false;
        for (Action action : actions) {
            if (operation.equals(action.operation())) {
                this.result = action.calculate(first, second);
                done = true;
                break;
            }
        }
        if (!done) {
            throw new NumberFormatException();
        }
    }

    /**
     * Get result.
     * @return int
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Class Add.
     */
    private class Add implements Action {

        /**
         * Arithmetical operations.
         *
         * @return String
         */
        @Override
        public String operation() {
            return "+";
        }

        /**
         * Calculate.
         *
         * @param first  int
         * @param second int
         * @return int
         */
        @Override
        public int calculate(int first, int second) {
            return first + second;
        }
    }

    /**
     * Class Div.
     */
    private class Div implements Action {

        /**
         * Arithmetical operations.
         *
         * @return String
         */
        @Override
        public String operation() {
            return "/";
        }

        /**
         * Calculate.
         *
         * @param first  int
         * @param second int
         * @return int
         */
        @Override
        public int calculate(int first, int second) {
            if (second != 0) {
                return first / second;
            } else {
                throw new ArithmeticException("div by zero.");
            }
        }
    }

    /**
     * Class Multiple.
     */
    private class Multiple implements Action {

        /**
         * Arithmetical operations.
         *
         * @return String
         */
        @Override
        public String operation() {
            return "*";
        }

        /**
         * Calculate.
         *
         * @param first  int
         * @param second int
         * @return int
         */
        @Override
        public int calculate(int first, int second) {
            return first * second;
        }
    }

    /**
     * Class Subtraction.
     */
    private class Subtraction implements Action {

        /**
         * Arithmetical operations.
         *
         * @return String
         */
        @Override
        public String operation() {
            return "-";
        }

        /**
         * Calculate.
         *
         * @param first  int
         * @param second int
         * @return int
         */
        @Override
        public int calculate(int first, int second) {
            return first - second;
        }
    }
}
