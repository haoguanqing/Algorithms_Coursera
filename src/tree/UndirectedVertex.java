package tree;

import java.util.ArrayList;
import java.util.List;

public class UndirectedVertex {
	final int data;
	List<UndirectedEdge> edges;
	int distance;

	public UndirectedVertex(int v) {
		data = v;
		edges = new ArrayList<>();
		distance = 1000000;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public void addEdge(UndirectedEdge e){
		if (!edges.contains(e)){
			edges.add(e);
		}
	}

	@Override
	public String toString() {
		return data + "," + edges + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		UndirectedVertex v = (UndirectedVertex) obj;
		if (this.data== v.data){
			return true;
		}
		return false;
	}
}
