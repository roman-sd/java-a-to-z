package ru.sdroman.calculator;

/**
 * Class InteractCalculator.
 *
 * @author sdroman
 * @version 0.1
 * @since 02.17
 */
public class InteractCalculator {

    /**
     * Memory.
     */
    private static final String MEMORY = "m";

    /**
     * Yes.
     */
    private static final String YES = "y";

    /**
     * No.
     */
    private static final String NO = "n";

    /**
     * Separator.
     */
    private static final String SN = System.getProperty("line.separator");

    /**
     * Input.
     */
    private Input input;

    /**
     * Output.
     */
    private Output output;

    /**
     * Calculator.
     */
    private Calculator calculator;

    /**
     * Constructs new InteractCalculator object.
     *
     * @param input      Input
     * @param output     Output
     * @param calculator Calculator
     */
    public InteractCalculator(Input input, Output output, Calculator calculator) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
    }

    /**
     * Runner.
     */
    public void action() {
        String memory = "";
        String result = "";
        do {
            do {
                if (memory != null) {
                    this.output.print(String.format("set 'm' to get result. %s", SN));
                }
                String first = this.input.ask("enter first arg: ");
                String operation = this.input.ask("enter operation: ");
                String second = this.input.ask("enter second arg: ");

                if (MEMORY.equals(first)) {
                    first = memory;
                }
                if (MEMORY.equals(second)) {
                    second = memory;
                }

                try {
                    this.calculator.selectOperation(operation, Integer.valueOf(first), Integer.valueOf(second));
                    result = String.valueOf(this.calculator.getResult());
                } catch (NumberFormatException nfe) {
                    this.output.print("error.");
                }
                this.output.print(String.format("Result: %s%s", result, SN));
                memory = result;
            } while (YES.equalsIgnoreCase(input.ask("memorize? y/n ")));
            memory = null;
        } while (NO.equalsIgnoreCase(input.ask("Exit: y/n ")));
    }
}
