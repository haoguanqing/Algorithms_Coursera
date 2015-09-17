package leetcode;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid0(String s){
		if (s==null){return false;}
        if (s==""){return true;}
        
        String[] lst = s.split("");
        if (lst.length%2==1){return false;}

        boolean isValid = true;
        for (int n=0;n<lst.length/2;n++){
            switch (lst[2*n]){
                case "(":
                    isValid = isValid && (lst[2*n+1].equals(")"));
                    break;
                case "[":
                	isValid = isValid && (lst[2*n+1].equals("]"));
                    break;
                case "{":
                	isValid = isValid && (lst[2*n+1].equals("}"));
                    break;
            }
        }
        return isValid;
	}
	
	public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
		for (String ss: s.split("")){
			if (!stack.isEmpty() && stack.peek().equals(this.oppositeParen(ss))){
				stack.pop();
			}else{
				stack.push(ss);
			}
		}
		if (stack.isEmpty()){
			return true;
		}else{
			return false;
		}
    }
    
    public String oppositeParen(String s){
        switch (s){
            case ")":
                return "(";
            case "]":
                return "[";
            case "}":
                return "{";
            default:
                return null;
        }
    }
	
	public static void main(String[] args) {
		Z.printf(isValid0("()")+"");
		Z.printf(isValid0("()[]")+"");
		Z.printf(isValid0("({})")+"");
		Z.printf(isValid0("({)}[]")+"");
		Z.printf(isValid0("{}()[]")+"");
		
	}
}
