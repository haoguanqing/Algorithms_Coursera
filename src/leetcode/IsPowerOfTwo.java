package leetcode;

public class IsPowerOfTwo {

	public boolean isPowerOfTwo(int n) {
		if (n<=0){
			return false;
		}
		if (n==1 || n==2){
			return true;
		}

		int r = n%2;
		if (r==1){
			return false;
		}else{
			return isPowerOfTwo(n/2);
		}
			
	}
	
	public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[l++] = nums[i];
            }
        }
        return l;
    }
	
	public boolean isUgly(int num) {
        if (num<1){
        	return false;
        }else if (num<=6&&num!=4){
        	return true;
        }
        
        if (num%2==0){
        	return isUgly(num/2);
        }else if (num%3==0){
        	return isUgly(num/3);
        }else if (num%5==0){
        	return isUgly(num/5);
        }else{
        	return false;
        }
    }
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		//compute Rectangle Area
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
	
    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        //wrong answer
    	//horizontal/vertical integer out of range
    	int totalArea = Math.abs((A-C)*(B-D))+Math.abs((E-G)*(F-H));
        int overlap = 0;
        
        int horizontal = Math.min(C,G) - Math.max(A,E);
        int vertical = Math.min(D,H) - Math.max(F,B);
        
        if (horizontal>0 && vertical>0){
            overlap = horizontal * vertical;
        }
        return totalArea - overlap;
    }

	public static void main(String[] args) {
		System.out.println(new IsPowerOfTwo().computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
		System.out.println(new IsPowerOfTwo().computeArea2(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
		
//		System.out.println(new IsPowerOfTwo().isUgly(127));
//		System.out.println(new IsPowerOfTwo().isUgly(33));
		
//		System.out.println(new IsPowerOfTwo().isPowerOfTwo(8192));
//		System.out.println(new IsPowerOfTwo().isPowerOfTwo(24));
//		System.out.println(new IsPowerOfTwo().isPowerOfTwo(0));
//		System.out.println(new IsPowerOfTwo().isPowerOfTwo(33));
//		
//		System.out.println(new IsPowerOfTwo().removeElement(new int[]{1, 2, 3, 4, 2,3},2));
		

	}

}
