package algorithms;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CountInversions {
	
	public static void main(String[] args) {
		long count = 0;
		ArrayList<Integer> lst = new ArrayList<>();
		try{
			lst = new CountInversions().ReadFromFile("IntegerArray.txt");
		}catch(FileNotFoundException e){
			System.out.println("File not found!!!!!");
		}finally {
			if(lst!=null){
				lst = new CountInversions().mergeSort(lst);
			}
			System.out.println(lst);
		}

	}
	
	public ArrayList<Integer> mergeSort(ArrayList<Integer> alst){
		int len = alst.size();
		long count = 0;
		if (len==0 || len==1){
			return alst;
		} else {
			int[] mergeList = new int[len];
			ArrayList<Integer> lst1 = new ArrayList();
			lst1.addAll(alst.subList(0, len/2));
			ArrayList<Integer> lst2 = new ArrayList();
			lst2.addAll(alst.subList(len/2, len-1));
			lst1 = new CountInversions().mergeSort(lst1);
			lst2 = new CountInversions().mergeSort(lst2);
			int i=0;
			int j=0;
			for(int k=0;k<len;k++){
				if (i==lst1.size()){
					mergeList[k] = lst2.get(j++);
				}
				else if (j==lst2.size()){
					mergeList[k] = lst1.get(i++);
				}
				else if (lst1.get(i)<lst2.get(j)){
					mergeList[k] = lst1.get(i++);
				}
				else{
					mergeList[k] = lst2.get(j++);
				}
			}
			ArrayList<Integer> result = new ArrayList();
			for (int s:mergeList){
				result.add(s);
			}
			return result;
		}
	}

	public long mergeCount(ArrayList<Integer> alst){
		int len = alst.size();
		if (len==0){
			return 0;
		} 
		else if(len==1){
			return 0;
		}
		else if(len==2){
			if (alst.get(0)>alst.get(1)){
				return 1;
			}else{
				return 0;
			}
		}
		else {
			int[] mergeList = new int[len];
			ArrayList<Integer> lst1 = new ArrayList();
			lst1.addAll(alst.subList(0, len/2));
			long count1 = this.mergeCount(lst1);
			int len1 = lst1.size();

			ArrayList<Integer> lst2 = new ArrayList();
			lst2.addAll(alst.subList(len/2, len-1));
			long count2 = this.mergeCount(lst2);
			int len2 = lst2.size();

			ArrayList<Integer> lst3 = this.mergeSort(lst1);
			ArrayList<Integer> lst4 = this.mergeSort(lst2);
			long count3 = 0;
			int i=0;
			int j=0;
			for(int k=0;k<len;k++){
				if (i==lst3.size()){
					mergeList[k] = lst4.get(j++);
				}
				else if (j==lst4.size()){
					mergeList[k] = lst3.get(i++);
					count3 = count3 + len1-1-i;
				}
				else if (lst3.get(i)<lst4.get(j)){
					mergeList[k] = lst3.get(i++);
				}
				else{
					mergeList[k] = lst4.get(j++);
					count3 = count3 + len1-1-i;
				}
			}

			return count1+count2+count3;
		}
	}

	private long CountInversionSimple(ArrayList<Integer> lst){
		long count = 0;
		for (int i=0;i<lst.size();i++){
			for (int j=i+1;j<lst.size();j++){
				if(lst.get(i)>lst.get(j)){
					count++;
				}
			}
		}
		return count;
	}

	
	
	//---------read from file------------
	public ArrayList<Integer> ReadFromFile(String fileName) throws FileNotFoundException{
		ArrayList<Integer> lst = new ArrayList();
		Scanner sc = new Scanner(new FileReader(fileName));
		while(sc.hasNextInt()){
			lst.add(sc.nextInt());
		}
		sc.close();
		return lst;
	}


}

