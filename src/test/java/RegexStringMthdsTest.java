
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegexStringMthdsTest extends BaseTest {
	
	/**
	 * Match method returns true if the WHOLE string can be matched,
	 * same as Pattern.matches(regex, str)
	 */
	@Test
	public void matchesTest() {
		assertTrue("2017".matches("-?\\d+")); // matches integers
		/*
		 assertTrue("-2017".matches("-?\\d+")); // matches negative integers
		 assertTrue("abc".matches("abc?")); // matches abc
		 assertTrue("ab".matches("abc?")); // matches ab
		 assertTrue("abc?".matches("abc\\?")); // question mark is escaped (to match literal)
		*/
	}
	
	/**
	 * Splits this string around matches of the given regular expression.
	 * The string "boo:and:foo".split("o") yields the following result:
	 * { "b", "", ":and:f" }
	 */
	@Test
	public void splitTest() {
		String[] expected = {"1", "2", "3", "4", "5"};
		assertEquals("1,2,3-4.5".split("[,.\\-]"), expected);
	}
	
	/**
	 * Replaces each substring of this string that matches the regex with the given replacement.
	 * Yields exactly the same result as
	 * Pattern.compile(regex).matcher(str).replaceAll(repl)
	 */
	@Test
	public void replaceTest() {
		String expected = "one!two!three!";
		String actual = "one?two2three/".replaceAll("\\d|[?/]", "!"); // replaces numbers or "?" or "/"
		logger.info(actual);
		assertEquals(actual, expected);
	}
	
	
}