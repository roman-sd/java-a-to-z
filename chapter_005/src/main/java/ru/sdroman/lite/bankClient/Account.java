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
     * equals.
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Account account = (Account) obj;

        if (Double.compare(account.value, value) != 0) return false;
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    /**
     * hashCode.
     * @return int
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
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
