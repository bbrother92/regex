import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.*;

public class RegexMatcherTest {
	
	/**
	 *
	 */
	@Test
	public void matcherTest() {
		String text = "ab3c \n sd3C";
		Pattern p = Pattern.compile("\\dC", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(text);
		System.out.println(m.find() ? text.substring(m.start(), m.end()) : "No match"); // 3c
		System.out.println(m.find() ? text.substring(m.start(), m.end()) : "No match");  // 3C
		
	}
	
	
	/**
	 * Prints
	 * Group 0: telephone Group 1: tele Group 2: phone
	 * Group 0: television Group 1: tele Group 2: vision
	 */
	@Test
	public void findGroupTest() {
		String text = "telephone television";
		Matcher m = Pattern.compile("(tele)(\\w*)").matcher(text);
		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				System.out.print("Group " + i + ": " + m.group(i) + " ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 *  By default, “.”  matches any character except a line terminator unless the DOTALL flag is specified
	 *
	 */
	@Test
	public void dotallFlagTest() {
		String text = "first line" + System.getProperty("line.separator")
				+ " second line";
		Pattern pattern = Pattern.compile("(.*)", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(text);
		matcher.find();
		assertEquals(text, matcher.group(1));
		System.out.println(matcher.group(1));
	}
	
	/**
	 * By default, ^ matches the beginning of the input, and $ matches the end of the input.
	 * So in order to match ^pattern$ anywhere use that flag.
	 */
	@Test
	public void multilineFlagTest() {
		String input = "cat\ndog\ngecko";
		Pattern p1 = Pattern.compile("^dog$");
		Pattern p2 = Pattern.compile("^dog$", Pattern.MULTILINE);
		Pattern p3 = Pattern.compile("(?m)^dog$"); // same as MULTILINE
		System.out.println(p1.matcher(input).find());
		System.out.println(p2.matcher(input).find());
		System.out.println(p3.matcher(input).find());
		
	}
}