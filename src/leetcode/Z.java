package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;
import java.util.regex.Pattern;


public class Z {
	
	public static void printf(String s){
		System.out.println(s);
	}
	
	
	public static void main(String[] args) {
		Hashtable<> table = new Hashtable<>();
		System.out.println(compress("abccc"));
		System.out.println(compress("aaabbbccc"));
		System.out.println(compress("aabbccc"));
		System.out.println(compress("a"));
		
	}
	
	public static String compress(String input) {
		if (input == null || input.length()==0){
			return input;
		}

		char c = input.charAt(0);
		StringBuilder result = new StringBuilder();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != c) {
				if (count != 0) {
					result.append(c);
					result.append(count);
				}
				c = input.charAt(i);
				count = 1;
			} else {
				count++;
				if (i==input.length()-1){
					result.append(c);
					result.append(count);
				}
			}
		}

		return input.length() < result.length() ? input : result.toString();
	}
	
	public static <T> boolean findPath(GraphNode<T> start, GraphNode<T> end) {
		//bfs
		if (start == null || end == null) {
			return false;
		}
		if (start.equals(end)){
			return true;
		}
		if (start.getChildren().size()==0){
			return false;
		}
		boolean result = false;
		List<GraphNode<T>> children = start.getChildren();
		for (GraphNode<T> node : children) {
			result = result || findPath(node, end);
			if (result){
				return true;
			}
		}
		return false;
	}
	
	public class GraphNode<T>{
		public List<GraphNode<T>> getChildren(){
			return null;
		}
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
