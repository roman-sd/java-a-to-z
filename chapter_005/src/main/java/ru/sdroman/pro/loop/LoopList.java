package ru.sdroman.pro.loop;

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
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
