package ru.sdroman.lite.bankClient;

/**
 * Class Account.
 *
 * @author sdroman
 * @since 04.17
 */
public class Account {

    /**
     * Value.
     */
    private double value;

    /**
     * Requisites.
     */
    private String requisites;

    /**
     * Constructs a new Account object.
     *
     * @param value      double
     * @param requisites String
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Returns value.
     *
     * @return double
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value double
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Returns requisites.
     *
     * @return String
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * ToString.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites='" + requisites + '\''
                + '}';
    }
}
