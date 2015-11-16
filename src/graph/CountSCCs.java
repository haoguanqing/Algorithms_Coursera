package graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author Guanqing
 * Computes the strongly connected components(SCC) in a directed graph
 * using Kosaraju's Two-Pass algorithm
 */
public class CountSCCs {
	private static int time;
	private static Vertex leader;
	static int count;

	public CountSCCs() {
		time = 0;
		leader = null;
		count = 0;
	}
	
	public static void DFS(DirectedGraph graph, Vertex vertex) {
		vertex.setExplored(true);
		vertex.setLeader(leader);
		for (Edge e: vertex.edges){
			if (!e.end.isExplored){
				DFS(graph, e.end);
			}
		}
		time++;
		vertex.setTime(time);
		count++;
	}

	public static void main(String[] args) throws FileNotFoundException{
		DirectedGraph g = new DirectedGraph();
		//g.readFromFile("SCC_test1_3221.txt");
		//g.readFromFile("SCC_test2_6321.txt");
		//g.readFromFile("SCC_test3_71.txt");
		//g.readFromFile("SCC_test4_333.txt");
		g.readFromFile("SCC.txt");
		
		g.reverse();
		for (int i=g.vertices.size();i>0;i--){
			Vertex v = g.vertices.get(i);
			if (!v.isExplored){
				leader = v;
				DFS(g,v);
			}
		}
		
		g.setTimes();
		g.reverse();
		ArrayList<Integer> SCCSizes = new ArrayList<>();
		for (int i=g.times.size();i>0;i--){
			int key = g.times.get(i);
			Vertex v = g.vertices.get(key);
			if (!v.isExplored){
				count=0;
				leader = v;
				DFS(g,v);
				SCCSizes.add(count);
			}
		}
		Collections.sort(SCCSizes, Collections.reverseOrder());
		System.out.println("The sizes of 10 largest SCCs are as follows: ");
		for (int i=0;i<10;i++){
			System.out.println(SCCSizes.get(i));
		}
		
	}
}


