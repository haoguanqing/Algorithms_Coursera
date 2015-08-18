package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
		final int data;
		final List<Edge> edges;
		int time;
		boolean isExplored;
		Vertex leader;
		
		public Vertex(int v){
			this.data = v;
			edges = new ArrayList<>();
			time = -1;
			isExplored = false;
		}
		
		public void setExplored(boolean b){
			isExplored = b;
		}
		
		public void setTime(int t){
			time = t;
		}
		
		public void setLeader(Vertex v){
			leader = v;
		}
		
		@Override
		public String toString() {
			return data + "," + edges + "\n";
		
	}

}
