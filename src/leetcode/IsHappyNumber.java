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
	
	//Given a non-negative integer num, 
	//repeatedly add all its digits until the result has only one digit.
	public int addDigits(int num){
		if(num<0){
			return 0;
		}
		if (num<10){
			return num;
		}
		int sum = 0;
		String s = num + "";
		String[] ss = s.split("");
		for (String str:ss){
			sum+= Integer.parseInt(str);
		}
		return addDigits(sum);
	}

	public static void main(String[] args) {
		for (int i=0;i<10;i++){
			boolean b = new IsHappyNumber().isHappy(i);
			Z.printf(i+", "+b+"\n");
			
		}
	}
	
}
