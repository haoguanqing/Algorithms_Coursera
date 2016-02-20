package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetPermute {
	
	
	//=============================================================
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums){
            list.add(i);
        }
    	//res.add(new ArrayList<Integer>(list));
        permuteHelper(res, list, nums.length, 0);
        
        return res;
    }
    
    public static void permuteHelper(List<List<Integer>> res,
                              List<Integer> list,
                              int len,
                              int pos){
    	if (pos + 1 < len){
            permuteHelper(res, list, len, pos + 1);
        }else if (pos + 1 == len){
        	res.add(new ArrayList<Integer>(list));
        }
        for (int i = pos + 1; i < len; i++){
            list.add(pos, list.remove(i));
            permuteHelper(res, list, len, i);
            res.add(new ArrayList<Integer>(list));
            list.add(i, list.remove(pos));
        }
    }
    
    //===========================================================
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s==null || s.length()>12 || s.length()<4){
            return res;
        }
        for (int i = 1; i < 4; i++){
            for (int j=i+1; j<i+4; j++){
                for (int k=j+1; k<s.length(); k++){
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, s.length());
                    System.out.println(s1+"."+s2+"."+s3+"."+s4 + "  " + 
                    		(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)));
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    
    public static boolean isValid(String s){
        if (s==null || (s.charAt(0)=='0' && s.length() > 1) || s.length()>3 || Integer.valueOf(s)>255){
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
    	for (List a : permute(new int[]{1,2,3})){
    		System.out.println(a);
    	}
    	char a = '0';
    	String b = "b";
    	String c = a+b;
    	System.out.println(restoreIpAddresses("172162541"));
	}
}
