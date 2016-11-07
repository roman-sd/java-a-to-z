package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringArrayTest {

	@Test
	public void whenTakeArrayThenDeleteDuplicateString() {
		StringArray stringArray = new StringArray();
		String[] array = new String[]{"aa", "bb", "aa", "dd", "aa"};
		String[] result = new String[]{"aa", "bb", "dd"};
		assertThat(stringArray.stringDuplicate(array), is(result));
	}
}
