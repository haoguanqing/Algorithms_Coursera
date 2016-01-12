package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.regex.Pattern;


public class Z {
	
	public static void printf(String s){
		System.out.println(s);
	}
	
	
	public static void main(String[] args) {
		char ch = 'a';
		char print = ch;
		for (int i=0;i<=6;i++){
			System.out.println((print++));
		}
		Queue<Integer> q = new LinkedList<>();
		
		ArrayList l = new ArrayList();
		
		String s = "aefawef";
		System.out.println(s.substring(1, 2));
		
		/*String s = "awefawef";
		for (String ss: s.split("")){
			printf(ss); 
		}*/
		
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	public static boolean isPalindrome(String s) {
        s = s.replaceAll("\\W", "");
        System.out.println(s);
        s = s.toLowerCase();
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
