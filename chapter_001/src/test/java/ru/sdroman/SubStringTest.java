package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SubStringTest {
	@Test
	public void whenTakeTwoStringThenIsContains() {
		SubString subString = new SubString();
		assertThat(subString.contains("abcdefghij", "cde"), is(true));
	}
}
