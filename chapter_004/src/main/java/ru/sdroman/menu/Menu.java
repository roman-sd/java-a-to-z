package ru.sdroman.menu;

/**
 * Class Menu.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class Menu {

    /**
     * Shows menu.
     *
     * @param nodes Node[]
     */
    public void showMenu(Node[] nodes) {
        for (Node node : nodes) {
            node.printNode();
        }
    }
}
