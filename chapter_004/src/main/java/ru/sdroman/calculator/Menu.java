package ru.sdroman.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Menu.
 *
 * @author sdroman
 * @version 0.2
 * @since 02.17
 */
public class Menu {

    /**
     * line separator.
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
    private Calculator calc;

    /**
     * Constructs new EngineerCalculator object.
     *
     * @param input  Input
     * @param output Output
     * @param calc   Calculator
     */
    public Menu(Input input, Output output, Calculator calc) {
        this.input = input;
        this.output = output;
        this.calc = calc;
    }

    /**
     * Check operation with RegExp.
     *
     * @param userNameString String
     * @return boolean
     */
    protected static boolean checkOperation(String userNameString) {
        Pattern p = Pattern.compile("[+-/*]");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    /**
     * Check memory.
     *
     * @param arg    String
     * @param memory String
     * @return String
     */
    private String checkMem(String arg, String memory) {
        return "m".equalsIgnoreCase(arg) ? memory : arg;
    }

    /**
     * Run Menu.
     */
    public void run() {
        String result = "";
        String memory = null;
        do {
            if (memory != null) {
                this.output.print(String.format("set 'm' to get previous result. %s", SN));
            }
            String operation = this.input.ask("enter operation: ");
            String first = this.input.ask("enter arg: ");

            String second;
            if (checkOperation(operation)) {
                second = this.input.ask("second arg: ");

            } else {
                second = "0";
            }
            first = checkMem(first, memory);
            second = checkMem(second, memory);

            try {
                calc.selectOperation(operation, Double.valueOf(first), Double.valueOf(second));
                result = String.valueOf(calc.getResult());
            } catch (NumberFormatException nfe) {
                this.output.print("error.");
            }
            this.output.print(String.format("Result: %s%s", result, SN));
            memory = result;
        } while ("n".equalsIgnoreCase(input.ask("Exit: y/n ")));
    }
}
