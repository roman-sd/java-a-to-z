package ru.sdroman.store.foods;

/**
 * Class Food.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class Food {

    /**
     * Name.
     */
    private String name;

    /**
     * Date expiry.
     */
    private String expiryDate;

    /**
     * Date create.
     */
    private String createDate;

    /**
     * Price.
     */
    private double price;

    /**
     * Discount.
     */
    private double discount;

    /**
     * Constructs new Food object.
     *
     * @param name       String
     * @param expiryDate String
     * @param createDate String
     */
    public Food(String name, String createDate, String expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
    }

    /**
     * Returns name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns date expiry.
     *
     * @return String
     */
    public String getExpireDate() {
        return expiryDate;
    }

    /**
     * Returns date create.
     *
     * @return String
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Returns price.
     *
     * @return double
     */
    public double getPrice() {
        return getDiscount() != 0 ? this.price - this.price * this.discount : price;
    }

    /**
     * Sets price.
     *
     * @param price double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns discount.
     *
     * @return double
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets discount.
     *
     * @param discount double
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Sets expiry date.
     * @param expiryDate String
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Sets create date.
     * @param createDate String
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * toString.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "{name='" + name + '\''
                + ", createDate=" + createDate
                + ", expiryDate=" + expiryDate
                + ", price=" + getPrice()
                + ", discount=" + discount + '}';
    }
}
