package algorithms;

import java.lang.reflect.Constructor;

public class IsPalindrome {
	
	public IsPalindrome(){
		
	}

	public static boolean IsPalindrome(int x) {
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
	
	public static void main(String[] args) {
		System.out.println(IsPalindrome(1001));
	}

}
