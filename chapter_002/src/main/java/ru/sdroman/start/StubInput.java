package ru.sdroman.start;

/**
 * Class to input implement Input.
 */
public class StubInput implements Input {

    /**
     * Array used for input.
     */
    private String[] answers;

    /**
     * Position in array.
     */
    private int position = 0;

    /** Creates a new StubInput object.
     * @param answers String array.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Asks the question and returns a answer.
     * @param question String
     * @return String answer
     */
    public String ask(String question) {
            return answers[position++];
    }
}
