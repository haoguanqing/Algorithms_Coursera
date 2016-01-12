package leetcode;

public class IsPalindrome {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(1001));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        
        int div = 1;
        while (x/div>=10){
            div *= 10;
        }
        
        while(x>0){
            int left = x/div;
            int right = x % 10;
            if (left!=right){
            	System.out.println(left +","+right);
                return false;
            }
            x %= div;
            x /= 10;
            div /= 100;
            
        }
        return true;
    
    }
	
	public static boolean isPalindrome(String s) {
        s = s.replaceAll("\\W", "");
        s = s.toLowerCase();
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
