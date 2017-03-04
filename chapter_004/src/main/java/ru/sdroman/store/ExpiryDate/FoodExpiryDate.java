package ru.sdroman.store.ExpiryDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class FoodExpiryDate.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class FoodExpiryDate {

    /**
     * Parse.
     *
     * @param dateStr String
     * @return LocalDate
     */
    private LocalDate stringToLocalDate(String dateStr) {
        return LocalDate.parse(dateStr);
    }

    /**
     * Returns expiry date in percent.
     *
     * @param create String
     * @param expiry String
     * @return double
     */
    public double expiryDatePercent(String create, String expiry) {
        LocalDate createDate = stringToLocalDate(create);
        LocalDate expiryDate = stringToLocalDate(expiry);
        long currentPeriod = ChronoUnit.DAYS.between(createDate, LocalDate.now());
        long expiryPeriod = ChronoUnit.DAYS.between(createDate, expiryDate);
        return 1 - (double)  currentPeriod / expiryPeriod;
    }
}
