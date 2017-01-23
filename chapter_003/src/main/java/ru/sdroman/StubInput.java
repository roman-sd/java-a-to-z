package ru.sdroman;

/**
 * Class StubInput for help input.
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

    /**
     * Creates a new StubInput object.
     * @param answers String array
     */
    StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Asks the question and returns a answer.
     * @return String answer
     */
    @Override
    public String ask() {
        System.out.println(answers[position]);
        return answers[position++];
    }
}
