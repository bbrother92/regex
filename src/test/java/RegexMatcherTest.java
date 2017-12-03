import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.*;

public class RegexMatcherTest extends BaseTest {
	
	/**
	 *
	 */
	@Test
	public void matcherTest() {
		String text = "ab3c \n sd3C";
		Pattern p = Pattern.compile("\\dC", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(text);
		logger.info(m.find() ? text.substring(m.start(), m.end()) : "No match"); // 3c
		logger.info(m.find() ? text.substring(m.start(), m.end()) : "No match");  // 3C
		
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
				logger.info("Group " + i + ": " + m.group(i) + " ");
			}
			logger.info("\n");
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
		logger.info(matcher.group(1));
	}
	
	/**
	 * By default, ^ matches the beginning of the input, and $ matches the end of the input.
	 * So in order to match ^pattern$ anywhere use that flag.
	 */
	@Test
	public void multilineFlagTest() {
		String input = "cat\ndog\ngecko";
		Pattern p1 = Pattern.compile("^dog$"); //false
		Pattern p2 = Pattern.compile("^dog$", Pattern.MULTILINE); //true
		Pattern p3 = Pattern.compile("(?m)^dog$"); // same as MULTILINE
		
	}
}