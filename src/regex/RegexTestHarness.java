package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Test harness for regular expression
 */
public class RegexTestHarness {

	public static void main(String[] args) throws IOException{
		//find all words
		/*System.out.println("Regex: [a-zA-Z]+");
		Pattern pattern2 = Pattern.compile("[a-zA-Z]+");
		System.out.println("Input string: Gag12 waht 2904, ger? se-ger; guanqing@seas.upenn\n");
		Matcher matcher2 = 
				pattern2.matcher("Gag12 waht 2904, ger? se-ger; guanqing@seas.upenn");*/
		
		//find quotes
		//String regex = "\"([^\"\n]*)([?!-.])\"";
		String regex = "\"([^\"\n]*)\"";
		System.out.println("Regex: " + regex);
		Pattern pattern2 = Pattern.compile(regex);
		String input = "'Gag12 waht 2904, ger?' \"se-ger,\" as, \"awef!\"; guanqing@seas.upenn\n"
				+ "Wahahaha! \"Silencer, \n100 int?!\"";
		System.out.println("Input string: "+input);
		Matcher matcher2 = pattern2.matcher(input);
		
		boolean found2 = false;
		while (matcher2.find()) {
			String s = String.format("Found" +
					" %s starting at " +
					"index %d and ending at index %d.",
					matcher2.group(),
					matcher2.start(),
					matcher2.end());
			System.out.println(s);
			found2 = true;
		}
		if(!found2){
			System.out.println("No match found.");
		}


		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("\nEnter your regex: ");
			Pattern pattern = 
					Pattern.compile(br.readLine());
			System.out.print("Enter input string to search: ");
			Matcher matcher = 
					pattern.matcher(br.readLine());

			boolean found = false;
			while (matcher.find()) {
				String s = String.format("I found the text" +
						" \"%s\" starting at " +
						"index %d and ending at index %d.%n",
						matcher.group(),
						matcher.start(),
						matcher.end());
				System.out.println(s);
				found = true;
			}
			if(!found){
				System.out.print("No match found.%n");
			}
		}
	}
}














