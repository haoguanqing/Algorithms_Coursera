package algorithms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class AdjacencyList {
	private static ArrayList<Integer> verticesList;
	private static ArrayList<Edge> edgesList;

	public AdjacencyList() {
		verticesList = new ArrayList<>();
		edgesList = new ArrayList<>();
	}

	//---------read from file------------
	public void readFromFile(String fileName) throws FileNotFoundException{
		ArrayList<String> rawList = new ArrayList<>();

		//"kargerMinCut_test1_min2.txt"
		Scanner sc = new Scanner(new FileReader(fileName));
		while(sc.hasNextLine()){
			rawList.add(sc.nextLine());
		}
		sc.close();
		for (String line: rawList){
			String[] strLine = line.split(" ");
			int v = Integer.parseInt(strLine[0]);
			verticesList.add(v);
			Edge e = new Edge(v);
			for (int i=1;i<strLine.length;i++){
				e.addEdge(Integer.parseInt(strLine[i]));
			}
			edgesList.add(e);
		}
//		System.out.println(verticesList);
//		System.out.println(edgesList);
	}

	public void randomContraction(){
		if (verticesList.size()<=2){return;}

		Random r = new Random();
		//get two random vertices that are connected
		int index1 = r.nextInt(verticesList.size()-1);
		int v1 = verticesList.get(index1);
		Edge e1 = edgesList.get(index1);
		
		int index2 = verticesList.indexOf(e1.getRandomVertex());
		int v2 = verticesList.get(index2);
		Edge e2 = edgesList.get(index2);
//		System.out.print("v1=" +v1);
//		System.out.println(" v2=" +v2);

		updateEdges(v1, v2);
		e2.mergeWith(e1);
		
		verticesList.remove(index1);
		edgesList.remove(index1);
//		System.out.println(verticesList);
//		System.out.println(edgesList);
	}

	public int getMinCuts(){
		if (verticesList.size()!=2){
			return 0;
		}else{
			return edgesList.get(0).size();
		}
	}

	public static void updateEdges(int v1, int v2){
		for (Edge e: edgesList){
			e.updateVertex(v1, v2);
		}
	}

	public int size(){
		return verticesList.size();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}





	//--------------inner class Edge---------------------
	private static class Edge{
		int v;
		ArrayList<Integer> e;

		public Edge(int vertex){
			v = vertex;
			e = new ArrayList<>();
		}

		public void addEdge(int x){
			e.add(x);
		}

		//merge v1 into v2
		public void updateVertex(int v1, int v2){
			Iterator<Integer> iter = e.iterator();
			int count = 0;
			while(iter.hasNext()){
				int x = iter.next();
				if(x==v1){
					iter.remove();
					count++;
				}
			}
			if (count==0) return;
			for (int i=0;i<count;i++){
				e.add(v2);
			}
		}

		public void eliminateSelfLoop(){
			Iterator<Integer> iter = e.iterator();
			while(iter.hasNext()){
				int x = iter.next();
				if(x==v){
					iter.remove();
				}
			}
		}

		public void mergeWith(Edge edge){
			//v2 merge with v1
			e.addAll(edge.asList());
			eliminateSelfLoop();
		}
		
		public int getRandomVertex(){
			return e.get(new Random().nextInt(e.size()));
		}

		public ArrayList<Integer> asList(){
			return e;
		}
		
		public int size(){
			return e.size();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String s = "";
			for (int i: e){
				s+= i+" ";
			}
			s.trim();
			return "{"+s+"}\n";
		}
	}

}
