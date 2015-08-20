package tree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class DijkstraAlgorithm {
	Heap heap;
	private boolean DEBUG;

	public DijkstraAlgorithm(String fileName) {
		heap = new Heap();
		DEBUG = true;
		readFromFile(fileName);
	}
	
	public int findShortestPath(int target){
		System.out.println("Trying to find the shortest path to "+target+" ...");
		UndirectedVertex v = heap.extractMin();
		while (v.data != target){
			for (UndirectedEdge e: v.edges){
				int newDistance = v.distance+e.length;
//				System.out.println(e.toString());
//				System.out.println(newDistance);
				if (newDistance<e.getTheOtherVertex(v.data).distance){
					UndirectedVertex v2 = e.getTheOtherVertex(v.data);
					v2.setDistance(newDistance);
					heap.vHeap.remove(v2);
					heap.insert(v2);
				}
			}
			v = heap.extractMin();
			System.out.println(v.data +", distance "+v.distance);
		}
		return v.distance;
	}

	public void readFromFile(String fileName){
		try{
			System.out.println("Reading from file "+fileName+" ...");
			
			Scanner sc = new Scanner(new FileReader(fileName));
			while(sc.hasNextLine()){
				String[] line = sc.nextLine().trim().split(" ");
				//String[] line = sc.nextLine().trim().split("\t");
				UndirectedVertex source = new UndirectedVertex(Integer.parseInt(line[0]));
				if (source.data==1){
					source.setDistance(0);
				}
				heap.insert(source);
				System.out.println("insert source" + source);
				for (int i=1;i<line.length;i++){
					String[] edgeStr = line[i].split(",");
					UndirectedVertex end = new UndirectedVertex(Integer.parseInt(edgeStr[0]));
					int l = Integer.parseInt(edgeStr[1]);
					addEdges(source, end, l);
					heap.insert(end);
				}
			}
			sc.close();
			System.out.println("Graph successfully created.");
			if(DEBUG){System.out.println(heap);}
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	private void addEdges(UndirectedVertex v1, UndirectedVertex v2, int length){
		UndirectedEdge e = new UndirectedEdge(v1, v2, length);
		v1.addEdge(e);
		v2.addEdge(e);
	}
	
	public static void main(String[] args) {
		DijkstraAlgorithm d = new DijkstraAlgorithm("dijkstraData_test1.txt");
		System.out.println(d.findShortestPath(4));
	}

}
