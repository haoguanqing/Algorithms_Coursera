package median_maintenance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MedianMaintenance {
	private boolean DEBUG;

	MinHeap highHeap;
	MaxHeap lowHeap;
	ArrayList<Integer> medianList;
	int medianSum;

	public MedianMaintenance(String fileName){
		highHeap = new MinHeap();
		lowHeap = new MaxHeap();
		medianList = new ArrayList<>();
		medianSum = 0;

		DEBUG = false;

		readFromFile(fileName);
	}

	public void readFromFile(String fileName){
		try{
			System.out.println("Reading from file "+fileName+" ...");

			Scanner sc = new Scanner(new FileReader(fileName));
			while (sc.hasNextLine()){
				int n = Integer.parseInt(sc.nextLine());
				insertNumber(n);
				int currentMedian = getCurrentMedian();
				medianList.add(currentMedian);
				medianSum += currentMedian;

				if(DEBUG){
					System.out.println("read number: "+n);
					System.out.println(lowHeap);
					if(!highHeap.minHeap.isEmpty()){
						System.out.println(highHeap);
					}else{
						System.out.println("[]");
					}
					System.out.println("current median is "+ currentMedian + "\n");
				}
			}
			sc.close();
			
			if(DEBUG){
				for (int i: medianList){
					System.out.println(i);
					}
				}

		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}

	private void insertNumber(int n){
		if (highHeap.size()==0){
			if (lowHeap.size()==0){
				lowHeap.insert(n);
			}else{
				if (n>lowHeap.max()){
					highHeap.insert(n);
				}else{
					int m = lowHeap.extractMax();
					lowHeap.insert(n);
					highHeap.insert(m);
				}
			}
		}else{
			if (highHeap.size()==lowHeap.size()){
				if (n<highHeap.min()){
					lowHeap.insert(n);
				}else{
					int m = highHeap.extractMin();
					highHeap.insert(n);
					lowHeap.insert(m);
				}
			}else{
				if (n>lowHeap.max()){
					highHeap.insert(n);
				}else{
					int m = lowHeap.extractMax();
					lowHeap.insert(n);
					highHeap.insert(m);
				}
			}
		}
	}

	public int getCurrentMedian(){
		return lowHeap.max();
	}

	public static void main(String[] args) {

		MedianMaintenance m = new MedianMaintenance("Median.txt");
		System.out.println("The median sum modulo of Median.txt is "+m.medianSum%10000+"\n");
	}

}
