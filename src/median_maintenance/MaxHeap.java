package median_maintenance;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * maxHeap data structure
 * @author Guanqing
 *
 */
public class MaxHeap {
	List<Integer> maxHeap;

	public MaxHeap() {
		maxHeap = new ArrayList<>();
	}

	//---------public methods-----------
	public void insert(int v2){
		if (!maxHeap.contains(v2)){
			maxHeap.add(v2);
			siftUp();
		}
	}
	
	public int max(){
		return maxHeap.get(0);
	}

	public int extractMax(){
		int size = maxHeap.size();
		if (size==0){
			throw new NoSuchElementException();
		} else if(size==1){
			return maxHeap.remove(0);
		} else{
			swap(0, size-1);
			int v = maxHeap.remove(size-1);
			siftDown();
			return v;
		}
	}

	public int size(){
		return maxHeap.size();
	}

	//----------private helper functions-------------
	private void siftUp(){
		int child = maxHeap.size()-1;
		while (child>0){
			int root = (child-1)/2;
			if(isBiggerThan(child, root)){
				swap(child, root);
				child = root;
			}
			else{
				child = 0;
			}
		}
	}

	private void siftDown(){
		int size = maxHeap.size();
		if (size==0 || size==1){return;}
		
		int root = 0;
		while (root*2+1<size){
			int child = root*2+1;
			if(child+1<size && isBiggerThan(child+1, child)){
				child += 1;
			}
			
			if(isBiggerThan(child, root)){
				swap(child, root);
				root = child;
			}else{
				return;
			}
		}
	}

	private boolean isBiggerThan(int child, int root){
		if (maxHeap.get(child) > maxHeap.get(root)){
			return true;
		}
		return false;
	}

	private void swap(int a, int b){
		if (a==b){return;}

		if (b<a){
			int v1 = maxHeap.remove(a);
			int v2 = maxHeap.remove(b);
			maxHeap.add(b, v1);
			maxHeap.add(a, v2);
		}else{
			int v2 = maxHeap.remove(b);
			int v1 = maxHeap.remove(a);
			maxHeap.add(a, v2);
			maxHeap.add(b, v1);
		}
	}

	@Override
	public String toString() {
		return maxHeap.toString();
	}
}
