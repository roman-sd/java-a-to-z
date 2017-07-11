package ru.sdroman.pro.testtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class Run.
 * @author sdroman
 * @since 06.2017
 */
public class Run {

    /**
     * Map of books.
     */
    private Map<String, Book> bookMap = new HashMap<>();

    /**
     * Gets orders from map and distributes them to books.
     * @param map Map
     */
    public void distOrders(Map<Integer, Order> map) {
        for (Order order : map.values()) {
            String book = order.getBook();
            Book tmpBook = bookMap.get(book);
            if (tmpBook == null) {
                tmpBook = new Book();
                bookMap.put(book, tmpBook);
                tmpBook.getBid().put(order.getPrice(), order);
            } else {
                if ("BUY".equals(order.getOperation())) {
                    checkDuplicate(order, tmpBook.getBid());
                } else {
                    checkDuplicate(order, tmpBook.getAsk());
                }
            }
        }

        for (Book books : bookMap.values()) {
            checkProfit(books.getBid(), books.getAsk());
        }
    }

    /**
     * Checks duplicates and calculate volumes.
     * @param order Order
     * @param map Map
     */
    private void checkDuplicate(Order order, Map<Double, Order> map) {
        if (map.containsKey(order.getPrice())) {
            Order tmpOrder = new Order(order.getBook(),
                    order.getOperation(),
                    order.getPrice(),
                    order.getVolume() + map.get(order.getPrice()).getVolume(),
                    order.getOrderId());
            map.put(order.getPrice(), tmpOrder);
        } else {
            map.put(order.getPrice(), order);
        }
    }

    /**
     *
     * @param bid Map
     * @param ask Map
     */
    private void checkProfit(Map<Double, Order> bid, Map<Double, Order> ask) {
        int indexBid = 0;
        int indexAsk = 0;
        int dif;
        ArrayList<Double> bidList = new ArrayList<>(bid.keySet());
        ArrayList<Double> askList = new ArrayList<>(ask.keySet());

        while (indexBid < bidList.size() && indexAsk < askList.size()) {
            double keyBid = bidList.get(indexBid);
            double keyAsk = askList.get(indexAsk);
            if (keyBid >= keyAsk) {
                dif = bid.get(keyBid).getVolume() - ask.get(keyAsk).getVolume();
                if (dif > 0) {
                    bid.get(keyBid).setVolume(dif);
                    ask.remove(keyAsk);
                    indexAsk++;
                } else if (dif < 0) {
                    ask.get(keyAsk).setVolume(-dif);
                    bid.remove(keyBid);
                    indexBid++;
                } else {
                    bid.remove(keyBid);
                    ask.remove(keyAsk);
                    indexBid++;
                    indexAsk++;
                }
            } else {
                break;
            }
        }
        showResult(bid, ask);
    }

    /**
     * Console output.
     * @param buy Map
     * @param sell Map
     */
    private void showResult(Map<Double, Order> buy, Map<Double, Order> sell) {
        StringBuilder builder = new StringBuilder();
        System.out.println(String.format("%7s %12s", "BID", "ASK"));
        System.out.println("Volume@Price – Volume@Price");

        Iterator<Double> bidIterator = buy.keySet().iterator();
        Iterator<Double> askIterator = sell.keySet().iterator();
        while (bidIterator.hasNext() && askIterator.hasNext()) {
            Order bid = buy.get(bidIterator.next());
            Order ask = sell.get(askIterator.next());
            builder.append(String.format("%6s@%s", bid.getVolume(), bid.getPrice()))
                    .append(String.format("%8s@%s", ask.getPrice(), ask.getVolume()))
                    .append(System.getProperty("line.separator"));
            if (!bidIterator.hasNext() && askIterator.hasNext()) {
                builder.append("  ---------").append(String.format("%8s@%s", ask.getPrice(), ask.getVolume()));
            } else if (bidIterator.hasNext() && !askIterator.hasNext()) {
                builder.append(String.format("%6s@%s", bid.getVolume(), bid.getPrice())).append("   ---------");
            }
        }
        System.out.println(builder);
    }
}
