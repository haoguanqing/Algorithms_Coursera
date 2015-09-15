package leetcode;

public class ComputeArea {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int totalArea = Math.abs((A-C)*(B-D))+Math.abs((E-G)*(F-H));
        int overlap = 0;
        
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(D,H);
        int bottom = Math.max(F,B);
        
        if (right>left && top>bottom){
            overlap = (top-bottom)*(right-left);
        }
        return totalArea - overlap;
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
