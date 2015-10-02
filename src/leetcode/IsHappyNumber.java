package leetcode;

import java.util.HashSet;
import java.util.Set;

public class IsHappyNumber {
	public boolean isHappy(int n) {
		if (n==0){return true;}
        int r = 0;
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            
            r = 0;
            while(n!=0){
                r += (n%10)*(n%10);
                n=n/10;
            }
            n = r;
        }
        return set.contains(1);
    }

	public static void main(String[] args) {
		for (int i=0;i<10;i++){
			boolean b = new IsHappyNumber().isHappy(i);
			Z.printf(i+", "+b+"\n");
			
		}
	}
	
}
