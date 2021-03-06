package ru.sdroman.pro.list.loop;

/**
 * Class LoopList.
 *
 * @author sdroman
 * @since 04.17
 */
public class LoopList {

    /**
     * HasCycle.
     *
     * @param first Node.
     * @return boolean
     */
    public boolean hasCycle(Node first) {
        Node firstItr = first;
        Node secondItr = first.next;

        while (!firstItr.equals(secondItr)) {
            if (secondItr == null || secondItr.next == null) {
                return false;
            }
            firstItr = firstItr.next;
            secondItr = secondItr.next.next;
        }
        return true;
    }

    /**
     * Class Node.
     *
     * @param <T>
     */
    public static class Node<T> {
        /**
         * Value.
         */
        T value;

        /**
         * Next.
         */
        Node<T> next;

        /**
         * Constructs an new Node object.
         * @param value T
         */
        Node(T value) {
            this.value = value;
        }

        /**
         * Sets next.
         * @param next Node
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
