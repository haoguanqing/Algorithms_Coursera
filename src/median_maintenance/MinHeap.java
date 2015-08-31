package median_maintenance;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * minHeap data structure
 * @author Guanqing
 *
 */
public class MinHeap {
	List<Integer> minHeap;

	public MinHeap() {
		minHeap = new ArrayList<>();
	}

	//---------public methods-----------
	public void insert(int v2){
		if (!minHeap.contains(v2)){
			minHeap.add(v2);
			siftUp();
		}
	}
	
	public int min(){
		if (minHeap.isEmpty()){throw new NoSuchElementException("minHeap is empty!");}
		return minHeap.get(0);
	}

	public int extractMin(){
		int size = minHeap.size();
		if (size==0){
			throw new NoSuchElementException();
		} else if(size==1){
			return minHeap.remove(0);
		} else{
			swap(0, size-1);
			int v = minHeap.remove(size-1);
			siftDown();
			return v;
		}
	}
	
	public int size(){
		return minHeap.size();
	}

	//----------private helper functions-------------
	private void siftUp(){
		if (minHeap.size()==0 || minHeap.size()==1){return;}
		
		int child = minHeap.size()-1;
		while (child>0){
			int root = (child-1)/2;
			if(isSmallerThan(child, root)){
				swap(child, root);
				child = root;
			}
			else{
				break;
			}
		}
	}

	private void siftDown(){
		int size = minHeap.size();
		if (size==0 || size==1){return;}
		
		int root = 0;
		while (root*2+1<size){
			int child = root*2+1;
			if(child+1<size && isSmallerThan(child+1, child)){
				child += 1;
			}
			
			if(isSmallerThan(child, root)){
				swap(child, root);
				root = child;
			}else{
				return;
			}
		}
	}

	private boolean isSmallerThan(int position1, int position2){
		if (minHeap.get(position1) < minHeap.get(position2)){
			return true;
		}
		return false;
	}

	private void swap(int a, int b){
		if (a==b){return;}

		if (b<a){
			int v1 = minHeap.remove(a);
			int v2 = minHeap.remove(b);
			minHeap.add(b, v1);
			minHeap.add(a, v2);
		}else{
			int v2 = minHeap.remove(b);
			int v1 = minHeap.remove(a);
			minHeap.add(a, v2);
			minHeap.add(b, v1);
		}
	}

	@Override
	public String toString() {
		return minHeap.toString();
	}
}