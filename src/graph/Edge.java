package graph;

public class Edge {
	Vertex start, end;
	boolean isReverse;
	
	public Edge(Vertex s, Vertex e){
		start = s;
		end = e;
		isReverse = false;
	}
	
	public void reverse(){
		Vertex temp;
		temp = start;
		start = end;
		end = temp;
		isReverse = !isReverse;
	}
	
	@Override
	public String toString() {
		return start.data + "->" + end.data;
	}
}
