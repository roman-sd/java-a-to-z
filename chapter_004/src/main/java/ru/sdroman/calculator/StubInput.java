package ru.sdroman.calculator;

import java.util.Iterator;

/**
 * Class StubInput.
 */
public class StubInput implements Input {

    /**
     * Answers iterator.
     */
    private final Iterator<String> answers;

    /**
     * Output.
     */
    private final Output output;

    /**
     * Constructs new StubInput object.
     *
     * @param answers Iterator
     * @param output  Output
     */
    public StubInput(Iterator<String> answers, Output output) {
        this.answers = answers;
        this.output = output;
    }

    /**
     * Ask the question and return answer.
     *
     * @param question String
     * @return String
     */
    @Override
    public String ask(String question) {
        this.output.print(question);
        return this.answers.next();
    }
}
