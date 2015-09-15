package leetcode;

public class LengthOfLastWord {
	/**
	 * Given a string s consists of upper/lower-case alphabets and 
	 * empty space characters ' ', return the length of last word in the string
	 * if not exist, return 0
	 * @param s
	 * @return lengthOfLastWord
	 */
	public int lengthOfLastWord(String s){
		if (s==""){
			return 0;
		}
		String[] s2 = s.trim().split(" ");
		String s3 = s2[s2.length-1];
        return s3.length();
	}
	
	public void print(String s){
		System.out.println(lengthOfLastWord(s));
	}
	
	public static void main(String[] args) {
		new LengthOfLastWord().print("Hello World");
		
	}

}
