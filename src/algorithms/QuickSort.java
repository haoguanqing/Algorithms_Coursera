package algorithms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class QuickSort {
	public static int comparisonNumber = 0;
	
	public static void main(String[] args) {
		int[] lst = new int[10000];
		int[] lst2 = new int[10000];
		int[] lst3 = new int[10000];
		int[] lst4 = new int[10000];
		try{
			lst = ReadFromFile("QuickSort.txt");
			lst2 = ReadFromFile("QuickSort.txt");
			lst3 = ReadFromFile("QuickSort.txt");
			lst4 = ReadFromFile("Median_test10000.txt");
		}catch(FileNotFoundException e){
			System.out.println("File not found!!!!!");
		}finally{
			quickSortInit(lst);
			System.out.print("quickSortInit - ");
			getComparison();
			
			quickSortFinal(lst2);
			System.out.print("quickSortFinal - ");
			getComparison();
			
			quickSortMedian(lst3);
			System.out.print("quickSortMedian - ");
			getComparison();
			
			quickSortMedian(lst4);
			System.out.print("quickSortMedian - " + getMedian(lst4, 0, lst4.length-1));
		}
		
	}

	
	//----------Quick sort methods----------

	//choose the first element as the pivot
	public static void quickSortInit(int[] lst){
		if (lst.length==0 || lst.length==1) return;

		clearComparison();
		partitionInit(lst, 0, lst.length-1);
	}
	public static void partitionInit(int[] lst, int l, int r){
		if (l>=r) return;

		int p = lst[l];
		int i = l+1;
		for (int j=l+1;j<=r;j++){
			if (lst[j]<p){
				swapElements(lst, j, i);
				i++;
			}
			addComparison();
		}
		swapElements(lst, l, i-1);
		partitionInit(lst, l, i-2);
		partitionInit(lst, i, r);
	}
	
	//choose the final element as the pivot
	public static void quickSortFinal(int[] lst){
		if (lst.length==0 || lst.length==1) return;

		clearComparison();
		partitionFinal(lst, 0, lst.length-1);
	}
	public static void partitionFinal(int[] lst, int l, int r){
		if (l>=r) return;
		swapElements(lst, l, r);
		
		int p = lst[l];
		int i = l+1;
		for (int j=l+1;j<=r;j++){
			if (lst[j]<p){
				swapElements(lst, j, i);
				i++;
			}
			addComparison();
		}
		swapElements(lst, l, i-1);
		partitionFinal(lst, l, i-2);
		partitionFinal(lst, i, r);
	}
	
	//choose the median among 3 as the pivot
	public static void quickSortMedian(int[] lst){
		if (lst.length==0 || lst.length==1) return;

		clearComparison();
		partitionMedian(lst, 0, lst.length-1);
	}
	public static void partitionMedian(int[] lst, int l, int r){
		if (l>=r) return;
		int midIndex = l+ (r-l+2)/2-1;
		int median = getMedian(lst, l, r);
		if(median==r){
			swapElements(lst, l, r);
		}else if(median==midIndex){
			swapElements(lst, l, midIndex);
		}
		
		
		int p = lst[l];
		int i = l+1;
		for (int j=l+1;j<=r;j++){
			if (lst[j]<p){
				swapElements(lst, j, i);
				i++;
			}
			addComparison();
		}
		swapElements(lst, l, i-1);
		partitionMedian(lst, l, i-2);
		partitionMedian(lst, i, r);
	}

	//helper functions
	public static void swapElements(int[] lst, int l, int r){
		int z = lst[l];
		lst[l] = lst[r];
		lst[r] = z;
	}
	public static void getComparison(){
		System.out.println("Comparisons: "+comparisonNumber);
	}
	public static void addComparison(){
		comparisonNumber++;
	}
	public static void clearComparison(){
		comparisonNumber=0;
	}
	
	public static int getMedian(int[] lst, int l, int r){
		int m = l+ (r-l+2)/2-1;
		
		int a = lst[l];
		int b = lst[m];
		int c = lst[r];
		
		if ((a<b&&b<c)||(c<b&&b<a)){
			return m;
		}else if ((a<c&&c<b)||(b<c&&c<a)){
			return r;
		}else{
			return l;
		}
	}
	
	//----------read from file----------
	public static int[] ReadFromFile(String fileName) throws FileNotFoundException{
		int[] lst = new int[10000];
		Scanner sc = new Scanner(new FileReader(fileName));
		int i=0;
		while(sc.hasNextInt()){
			lst[i] = sc.nextInt();
			i++;
		}
		sc.close();
		return lst;
	}
}
