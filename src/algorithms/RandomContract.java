package algorithms;

import java.io.FileNotFoundException;

import javax.jws.Oneway;

public class RandomContract {

	public RandomContract() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int i = 0;
		String fileName = "kargerMinCut1.txt";
		int minCuts = oneCycleContract(fileName);
		while (i<500){
			int minCuts2 = oneCycleContract(fileName);
			if (minCuts>minCuts2){
				minCuts = minCuts2;
			}
			i++;
		}
		System.out.println("minCuts = " + minCuts);
		
	}
	
	public static int oneCycleContract(String fileName){
//		AdjacencyList adjList = new AdjacencyList();
//		try{
//			adjList.readFromFile("kargerMinCut_test1_min2.txt");
//		}catch(FileNotFoundException e){
//			System.out.println("File not found!!!!!");
//		}
//		while(adjList.size()>2){
//			adjList.randomContraction();
//		}
		
		AdjacencyList adjList2 = new AdjacencyList();
		try{
			adjList2.readFromFile(fileName);
			
		}catch(FileNotFoundException e){
			System.out.println("File not found!!!!!");
		}
		while(adjList2.size()>2){
			adjList2.randomContraction();
		}
		return adjList2.getMinCuts();
	}

}
