package tree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class DijkstraAlgorithm {
	Heap heap;
	private boolean DEBUG;
	HashMap<Integer, UndirectedVertex> vertexDataMap;

	public DijkstraAlgorithm(String fileName) {
		heap = new Heap();
		DEBUG = false;
		vertexDataMap = new HashMap<>();
		readFromFile(fileName);
	}
	
	public void findShortestPath(){
		System.out.println("Trying to find the shortest paths ...");
		while (!heap.vHeap.isEmpty()){
			UndirectedVertex v = heap.extractMin();
			v.setVisited();
			for (UndirectedEdge e: v.edges){
				int newDistance = v.distance+e.length;
				UndirectedVertex v2 = getVertex(e.getEndVertexData(v.data));
				if (!v2.visited)
				if ((!v2.visited)&&(newDistance<v2.distance)){
					v2.setDistance(newDistance);
					heap.vHeap.remove(v2);
					heap.insert(v2);
				}
			}
		}
		System.out.println("Shortest paths successfully defined");
	}

	public void readFromFile(String fileName){
		try{
			System.out.println("Reading from file "+fileName+" ...");
			
			Scanner sc = new Scanner(new FileReader(fileName));
			while(sc.hasNextLine()){
				//String[] line = sc.nextLine().trim().split(" ");
				String[] line = sc.nextLine().trim().split("\t");
				UndirectedVertex source = getVertex(Integer.parseInt(line[0]));
				if (source.data==1){
					source.setDistance(0);
				}
				heap.insert(source);
				for (int i=1;i<line.length;i++){
					String[] edgeStr = line[i].split(",");
					UndirectedVertex end = getVertex(Integer.parseInt(edgeStr[0]));
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
	
	public UndirectedVertex getVertex(int data){
		if (!vertexDataMap.containsKey(data)){
			vertexDataMap.put(data, new UndirectedVertex(data));
		}
		return vertexDataMap.get(data);
	}

	private void addEdges(UndirectedVertex v1, UndirectedVertex v2, int length){
		UndirectedEdge e = new UndirectedEdge(v1, v2, length);
		v1.addEdge(e);
		v2.addEdge(e);
	}
	
	public int[] getShortestPathOf(int[] data){
		int[] results = new int[data.length];
		int j=0;
		for (int i=0;i<data.length;i++){
			results[i] = vertexDataMap.get(data[i]).distance;
		}
		return results;
	}
	
	public static void printIntArray(int[] a){
		System.out.print("[");
		for (int i=0;i<a.length-1;i++){
			System.out.print(a[i]+",");
		}
		System.out.print(a[a.length-1]+"]");
	}
	
	public static void main(String[] args) {
		DijkstraAlgorithm d = new DijkstraAlgorithm("dijkstraData.txt");
//		DijkstraAlgorithm d = new DijkstraAlgorithm("dijkstra_test200.txt");
//		DijkstraAlgorithm d = new DijkstraAlgorithm("dijkstra_test20000.txt");
//		DijkstraAlgorithm d = new DijkstraAlgorithm("dijkstraData_test1.txt");
//		DijkstraAlgorithm d2 = new DijkstraAlgorithm("dijkstraData_test2.txt");
		d.findShortestPath();
		printIntArray(d.getShortestPathOf(
				new int[]{1,7,37,59,82,99,115,133,165,188,197}));
	}
}
