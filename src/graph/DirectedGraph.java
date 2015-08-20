package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DirectedGraph {
	final Map<Integer, Vertex> vertices;
	final Map<Integer, Integer> times;
	private boolean isReversed;
	private boolean DEBUG = false;
	
	public DirectedGraph() {
		vertices = new HashMap<Integer, Vertex>();
		times = new TreeMap<Integer, Integer>();
		isReversed = false;
	}
	
	public void readFromFile(String fileName){
		try{
			System.out.println("Reading from file "+fileName+" ...");
			
			Scanner sc = new Scanner(new FileReader(fileName));
			while(sc.hasNextLine()){
				String[] line = sc.nextLine().split(" ");
				Vertex start = getVertex(Integer.parseInt(line[0]));
				Vertex end = getVertex(Integer.parseInt(line[1]));
				addEdge(start, end);
			}
			sc.close();
			System.out.println("Graph successfully created.");
			if(DEBUG){System.out.println(vertices);}
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Vertex getVertex(Integer i){
		if (!vertices.containsKey(i)){
			vertices.put(i, new Vertex(i));
		}
		return vertices.get(i);
	}
	
	public void addEdge(Vertex start, Vertex end){
		Edge e = new Edge(start, end);
		start.edges.add(e);
		end.edges.add(e);
	}
	
	public void setTimes(){
		for (int i:vertices.keySet()){
			times.put(vertices.get(i).time, i);
		}
		if(DEBUG){System.out.println(times);}
	}
	
	public void reverse(){
		if (!isReversed){
			System.out.println("Reversing graph ...");
		}else{
			System.out.println("Reversing graph back ...");
		}
		
		for (Vertex v: vertices.values()){
			reverse(v);
		}
		isReversed = !isReversed;
		System.out.println("Reverse complete.");
		if(DEBUG){System.out.println(vertices);}
	}
	
	private void reverse(Vertex v){
		v.setExplored(false);
		List<Edge> toReverse = new ArrayList<>();
		for(Edge e:v.edges){
			if (e.isReverse == isReversed){
				toReverse.add(e);
			}
		}
		
        for (Edge e : toReverse) {
        	e.reverse();
        }
	}
	
	@Override
	public String toString() {
		return vertices.toString();
	}
	
	//----------vertex class----------
	/*public static class Vertex{
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
	}*/
	
	//----------edge class----------
/*	public static class Edge{
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
	}*/
}
