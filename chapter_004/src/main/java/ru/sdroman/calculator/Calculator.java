package ru.sdroman.calculator;

/**
 * Class Calculator.
 *
 * @author sdroman
 * @version 0.2
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
    protected Action[] actions = new Action[DEFAULT_CAPACITY];

    /**
     * Result.
     */
    private double result;

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
    public void selectOperation(String operation, double first, double second) {
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
     *
     * @return int
     */
    public double getResult() {
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
         * @param first  double
         * @param second double
         * @return int
         */
        @Override
        public double calculate(double first, double second) {
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
         * @param first  double
         * @param second double
         * @return int
         */
        @Override
        public double calculate(double first, double second) {
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
         * @param first  double
         * @param second double
         * @return int
         */
        @Override
        public double calculate(double first, double second) {
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
        public double calculate(double first, double second) {
            return first - second;
        }
    }
}
