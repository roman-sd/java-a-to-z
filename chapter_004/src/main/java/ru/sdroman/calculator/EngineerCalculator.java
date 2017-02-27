package ru.sdroman.calculator;

/**
 * Class EngineerCalculator.
 *
 * @author sdroman
 * @version 0.2
 * @since 02.17
 */
public class EngineerCalculator extends Calculator {

    /**
     * Position in action's array.
     */
    private int position;

    /**
     * Constructs new EngineerCalculator object.
     */
    public EngineerCalculator() {
        super();
        this.position = super.actions.length;
        addNewAction();
    }

    /**
     * Adds new actions.
     */
    private void addNewAction() {
        addFirst(new CosineAction());
        addAction(new SineAction());
    }

    /**
     * Array growth.
     */
    private void grow() {
        final int growLength = 5;
        Action[] temp = new Action[position + growLength];
        System.arraycopy(super.actions, 0, temp, 0, position);
        super.actions = temp;
    }

    /**
     * Adds first action in array.
     *
     * @param action Action
     */
    private void addFirst(Action action) {
        grow();
        super.actions[this.position++] = action;
    }

    /**
     * Add Action in array.
     *
     * @param action Action
     */
    public void addAction(Action action) {
        if (this.position == super.actions.length) {
            grow();
        }
        super.actions[this.position++] = action;
    }

    /**
     * Class CosineAction.
     */
    private class CosineAction implements Action {
        /**
         * Arithmetical operations.
         *
         * @return String
         */
        @Override
        public String operation() {
            return "cos";
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
            return calculate(first);
        }

        /**
         * Cosine.
         *
         * @param arg double
         * @return double
         */
        private double calculate(double arg) {
            return Math.cos(arg);
        }
    }

    /**
     * Class SineAction.
     */
    private class SineAction implements Action {
        /**
         * Arithmetical operations.
         *
         * @return String
         */
        @Override
        public String operation() {
            return "sin";
        }

        /**
         * Calculate.
         *
         * @param first  double
         * @param second double
         * @return double
         */
        @Override
        public double calculate(double first, double second) {
            return calculate(first);
        }

        /**
         * Sine.
         *
         * @param arg double
         * @return double
         */
        private double calculate(double arg) {
            return Math.sin(arg);
        }
    }
}
