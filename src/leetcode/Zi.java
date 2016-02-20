package leetcode;

public class Zi {
    
	public static void main(String[] args) {
		System.out.println("=====Interview=====");

		//System.out.println(totalCellsVisited(7,4));
		
		Test t1 = new Test("a");
		Test t2 = new Test("b");
		t2.start();
		t1.start();
		
/*		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();*/
		
	}
	
	static class Test implements Runnable{
		Thread thread;
		String name;
		
		public Test(String name){
			this.name = name;
		}
		
		@Override
		public void run() {
			while (true){
				System.out.println(name);
				try{
					thread.sleep(1000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
			
		}
		
		public void start(){
			if (thread == null){
				thread = new Thread(new Test(name));
				thread.start();
			}
		}
	}
	
	
	// Babai visited cells problem
	
	/*static int RIGHT = 102;
    static int BOTTOM = 103;
    static int LEFT = 104;
    static int TOP = 105;
    
    static int totalCellsVisited(int n, int m) {
        if (n == 0 || m == 0){
            return 0;
        }
        //Initialization
        boolean[][] visited = new boolean[n+2][m+2];
        for (int i = 0; i < m + 2; i++){
            visited[0][i] = true;
            visited[n+1][i] = true;
        }
        for (int i = 0; i < n + 2; i++){
            visited[i][0] = true;
            visited[i][m+1] = true;
        }
        int ans = visitCellHelper(visited, new Babai(1, 1, RIGHT));
        return ans;
    }

    private static int visitCellHelper(boolean[][] visited, Babai babai){
        visited[babai.n][babai.m] = true;
        
        int n = babai.nextX();
        int m = babai.nextY();
        int i = 0;
        while (i < 4 && visited[n][m]){
            babai.turnRight();
            n = babai.nextX();
            m = babai.nextY();
            i++;
        }
        if (i == 4){
            return 1;
        }
        Babai babai2 = new Babai(n, m, babai.direction);
        babai2.turnRight();
        return 1 + visitCellHelper(visited, babai2);
    }

    static class Babai{
        int n;
        int m;
        int direction;
        
        public Babai(int n, int m, int direction){
            this.n = n;
            this.m = m;
            this.direction = direction;
        }
        
        public void turnRight(){
            direction = (direction == TOP) ? RIGHT : direction+1;
        }
        
        public int nextX(){
            switch (direction){
                case 102: return n + 1;
                case 104: return n - 1;
                default: return n;
            }
        }
        
        public int nextY(){
            switch (direction){
                case 103: return m + 1;
                case 105: return m - 1;
                default: return m;
            }
        }
    }*/
	
}
