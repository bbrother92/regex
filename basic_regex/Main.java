
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[0-9]{3,5}");
		String st = " to sum up,To begin with, 2  23 456   12345   1234566   3 ";
		Matcher m = p.matcher(st);
		while (m.find()){
			System.out.println(st.substring(m.start(),m.end())+"*");

		}
								//SPLIT
		Pattern p2 = Pattern.compile("/");
		String[] arr = p2.split("one/two/three");
		System.out.println(Arrays.toString(arr));
		
		boolean res= Pattern.matches("^#?([a-f0-9]{6}|[a-f0-9]{3})$", "#8b2323");
		System.out.println(res);
		
		//==========================================================
					//STRING REPLACEALL ALSO WE HAVE MATCHes METHOD
		String st2 = "Seen you eyes son show. Far two unaffected one alteration apartments celebrated but middletons interested. Described deficient applauded consisted my me do. Passed edward two talent effect seemed engage six. On ye great do child sorry lived. Proceed cottage far letters ashamed get clothes day. Stairs regret at if matter to. On as needed almost at basket remain. By improved sensible servants children striking in surprise. ";
		System.out.println(st2.replaceAll("\\b[sS].\\w*", "*****"));
		//==========================================================
//									FIND
		System.out.println(st2);
		String regex = "\\b[a-s](\\w|\\.)+";
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(st2);
		int count = 0;
		while (m1.find()){count++;
			System.out.println("Matcher count "+count);
			System.out.println("m starts "+m.start());
			System.out.println("m end "+m.end());
		}
		//==========================================================
					//		FIND GROUP
		String st3 = "Seen you eyes son show. Far two unaffected one alteration apartments celebrated but middletons interested. Described deficient applauded consisted my me do. Passed edward two talent effect seemed engage six. On ye great do child sorry lived. Proceed cottage far letters ashamed get clothes day. Stairs regret at if matter to. On as needed almost at basket remain. By improved sensible servants children striking in surprise. ";
		String regex2 = "\\b[a-s](\\w|\\.)+";
		Pattern p3 = Pattern.compile(regex2,Pattern.UNICODE_CASE);
		Matcher m2 = p3.matcher(st3);
		while (m2.find()) {
			System.out.println(m2.group());
		}


		
	}
}
