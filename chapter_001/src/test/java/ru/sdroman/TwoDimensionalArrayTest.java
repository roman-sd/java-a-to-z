package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TwoDimensionalArrayTest {

	@Test
	public void whenSetArrayThenRotateArray() {
		TwoDimensionalArray testArray = new TwoDimensionalArray();
		int[][] expectedArray = new int[][] {{1, 2, 3, 4},
		                                     {5, 6, 7, 8}, 
		                                     {9, 10, 11, 12}, 
		                                     {13, 14, 15, 16}};
		int[][] actualArray = new int[][] {{4, 8, 12, 16}, 
		                                   {3, 7, 11, 15}, 
		                                   {2, 6, 10, 14}, 
		                                   {1, 5, 9, 13}};
	    assertThat(testArray.rotateArray(expectedArray), is(actualArray));
	}
}
