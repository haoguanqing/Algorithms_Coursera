package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "da ba ba da"));

	}
	
	public static boolean wordPattern(String pattern, String str) {
		if (pattern.equals("")||str.equals("")) return false;
        HashMap<String, String> map = new HashMap<>();
        String[] patternList = pattern.split("");
        String[] strList = str.split(" ");
        if(patternList.length!=strList.length) return false;

        for (int i=0;i<patternList.length;i++){
            if(map.get(patternList[i])!=null){
                if(!map.get(patternList[i]).equals(strList[i])){
                    return false;
                }
            }else{
                map.put(patternList[i], strList[i]);
            }
        }
        HashSet set = new HashSet();
        set.addAll(map.values());
        if(map.values().size()!=set.size()){
            return false;
        }
        return true;
    }

}
