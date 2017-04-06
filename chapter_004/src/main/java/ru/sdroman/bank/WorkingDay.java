package ru.sdroman.bank;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Class WorkingDay.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class WorkingDay {

    /**
     * Number of visitors.
     */
    private int n;

    /**
     * Constructs a new WorkingDay object.
     *
     * @param n int
     */
    public WorkingDay(int n) {
        this.n = n;
    }

    /**
     * Array sorting.
     *
     * @param array int[]
     * @return int[] sorting array
     */
    private int[] sort(int[] array) {
        int tmp;
        for (int i = 0; i < n + n - 1; i++) {
            for (int j = i + 1; j < n + n; j++) {
                if (abs(array[i]) > abs(array[j])) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * Returns array of seconds.
     *
     * @param list ArrayList
     * @return int[]
     */
    private int[] listToArray(List<Visitor> list) {
        final int arraySize = n + n;
        int[] array = new int[arraySize];
        Iterator<Visitor> iterator = list.iterator();
        Visitor currentTicket;
        for (int i = 0; i < n; i++) {
            currentTicket = iterator.next();
            array[i] = currentTicket.getStart().toSecondOfDay();
            array[arraySize - 1 - i] = currentTicket.getFinish().toSecondOfDay() * -1;
        }
        return array;
    }

    /**
     * maxVisitorsPeriod.
     *
     * @param list ArrayList
     * @return String
     */
    public String maxVisitorPeriod(List<Visitor> list) {
        int startSec = 0;
        int finishSec = 0;
        int visitsCount = 0;
        final int arraySize = n + n;
        int[] visitsArray = sort(listToArray(list));
        int count = 0;
        int tmp = 0;

        for (int i = 0; i < arraySize; i++) {
            if (visitsArray[i] > 0) {
                count++;
                tmp = visitsArray[i];
            } else {
                if (count > visitsCount) {
                    visitsCount = count;
                    startSec = tmp;
                    finishSec = visitsArray[i] * -1;
                }
                count--;
            }
        }
        return LocalTime.ofSecondOfDay(startSec).toString()
                + " - " + LocalTime.ofSecondOfDay(finishSec).toString();
    }
}
