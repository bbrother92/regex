import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class RegexMatcherTest {
	
	/**
	 *
	 */
	@Test
	public void matcherTest() {
		String text = "ab3c";
		Pattern p = Pattern.compile("\\dC", Pattern.CASE_INSENSITIVE); // match 3c and 3C
		Matcher m = p.matcher(text);
		System.out.println(m.find() ? text.substring(m.start(), m.end()) : "No match");
		
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
	
	
}