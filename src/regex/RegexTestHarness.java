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
        /*Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {

            Pattern pattern = 
            Pattern.compile(console.readLine("%nEnter your regex: "));

            Matcher matcher = 
            pattern.matcher(console.readLine("Enter input string to search: "));

            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
                console.format("No match found.%n");
            }
        }*/
		
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Enter your regex: ");
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














