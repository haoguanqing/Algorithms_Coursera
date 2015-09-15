package leetcode;

public class SqrtInt {
	
	/**
	 * Use Newton's method to find root square
	 * https://en.wiki2.org/wiki/Methods_of_computing_square_roots
	 * https://en.wikipedia.org/wiki/Newton%27s_method
	 * @param x
	 * @return sqrt(x)
	 */
    public int mySqrt(int x) {
        if (x<=0){
            return 0;
        }

        int d = 1, n=0;
        while (x/d>=100){
            d*=100;
            n++;
        }
        double s = 0;
        double s2 = 6*10^n;
        
        while (s2!=s){
            s = s2;
            s2 = (s+ x/s)/2;
        }
        return (int) s;
    }
	
	public static void main(String[] args) {
		for (int i=0;i<18;i++){
			System.out.println("i="+i+", sqrt="+new SqrtInt().mySqrt(i));
		}
		System.out.println("i="+2147395599+", sqrt="+new SqrtInt().mySqrt(2147395599));
		
	}

}
