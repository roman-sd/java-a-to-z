package ru.sdroman.pro.tree.bst;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Test BinarySearchTree class.
 *
 * @author sdroman
 * @since 05.2017
 */
public class BinarySearchTreeTest {

    /**
     * Tree.
     */
    private ITree<Integer> tree = new BinarySearchTree<>();

    /**
     * Test addRoot method.
     */
    @Test
    public void whenAddCallFirstTimeThenAddRootCall() {
        tree.add(10);
        assertThat(tree.root().getValue(), is(10));
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsElementToTheLeft() {
        Node<Integer> node = tree.add(10);
        tree.add(9);
        assertThat(node.getLeft().getValue(), is(9));
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsElementToTheRight() {
        Node<Integer> node = tree.add(10);
        tree.add(11);
        assertThat(node.getRight().getValue(), is(11));
    }

    /**
     * Test search method.
     */
    @Test
    public void whenSearchCallThenFindNodeInTree() {
        tree.add(10);
        tree.add(7);
        tree.add(35);
        Node<Integer> node = tree.add(20);
        tree.add(99);
        assertThat(tree.search(20), is(node));
    }

    /**
     * Test search method.
     */
    @Test
    public void whenSearchCallAndNotFindThenReturnNull() {
        tree.add(10);
        tree.add(7);
        tree.add(35);
        assertNull(tree.search(20));
    }

    /**
     * Test size method.
     */
    @Test
    public void whenSizeCallThenReturnSizeOfTree() {
        tree.add(10);
        tree.add(4);
        tree.add(15);
        assertThat(tree.size(), is(3));
    }

    /**
     * Test children method.
     */
    @Test
    public void whenChildrenCallThenReturnsIterableCollectionOfChildren() {
        Node<Integer> rootNode = tree.add(10);
        Node<Integer> left = tree.add(7);
        Node<Integer> right = tree.add(35);
        List<Node<Integer>> actualList = new ArrayList<>();
        for (Node<Integer> node : tree.children(rootNode)) {
            actualList.add(node);
        }

        List<Node<Integer>> expectedList = new ArrayList<>();
        expectedList.add(right);
        expectedList.add(left);

        assertThat(actualList, is(expectedList));
    }

    /**
     * Test inOrder method.
     */
    @Test
    public void whenInOrderCallThenReturnIterableCollectionElementsOfTree() {
        Node<Integer> rootNode = tree.add(10);
        Node<Integer> left = tree.add(7);
        Node<Integer> right = tree.add(35);
        List<Node<Integer>> actualList = new ArrayList<>();
        for (Node<Integer> node : tree.inOrder()) {
            actualList.add(node);
        }

        List<Node<Integer>> expectedList = new ArrayList<>();
        expectedList.add(right);
        expectedList.add(rootNode);
        expectedList.add(left);

        assertThat(actualList, is(expectedList));
    }

    /**
     * Test iterator method.
     */
    @Test
    public void whenIteratorCallThenReturnElements() {
        tree.add(10);
        tree.add(7);
        tree.add(5);
        tree.add(35);
        tree.add(20);
        tree.add(99);
        Iterator<Integer> actualList = tree.iterator();
        List<Integer> list = new ArrayList<>();
        while (actualList.hasNext()) {
            list.add(actualList.next());
        }
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(5);
        expectedList.add(7);
        expectedList.add(10);
        expectedList.add(20);
        expectedList.add(35);
        expectedList.add(99);

        assertThat(list, is(expectedList));
    }
}
