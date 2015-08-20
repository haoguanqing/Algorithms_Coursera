package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * minHeap data structure for undirected graph with weighed edges
 * @author Guanqing
 *
 */
public class Heap {
	List<UndirectedVertex> vHeap;

	public Heap() {
		vHeap = new ArrayList<>();
	}

	//---------public methods-----------
	public void insert(UndirectedVertex v2){
		if (!vHeap.contains(v2)){
			vHeap.add(v2);
			siftUp();
		}else{

			for (UndirectedVertex v: vHeap){
				if (v.data==v2.data){
					for (UndirectedEdge e: v2.edges){
						if (!v.edges.contains(e)){
							v.edges.add(e);
						}
					}
				}
			}
		}

	}

	public UndirectedVertex extractMin(){
		int size = vHeap.size();
		if (size==0){
			throw new NoSuchElementException();
		} else if(size==1){
			return vHeap.remove(0);
		} else{
			UndirectedVertex v = vHeap.remove(0);
			siftDown();
			return v;
		}
	}

	//----------private helper functions-------------
	private void siftUp(){
		int size = vHeap.size();
		if (size==1){return;}

		int i=size-1;
		while ((i-1)/2>=0){
			if (i==0){return;}

			if (smallerThan(i, (i-1)/2)){
				swap(i,(i-1)/2);
				i=(i-1)/2;
			}else{
				return;
			}
		}
	}

	private void siftDown(){
		int size = vHeap.size();
		if (size==1){return;}

		UndirectedVertex v = vHeap.remove(size-1);
		vHeap.add(0, v);

		int i=0;
		while ((i*2+2)<size){
			//if there's only one child element, i.e. the last element in the heap
			if ((i*2+1)==size-1){
				if(smallerThan(2*i+1, i)){
					swap(i, 2*i+1);
					i = 2*i+1;
				}
			}
			//normal cases
			if(smallerThan(2*i+1, 2*i+2)){
				if(smallerThan(2*i+1, i)){
					swap(i, 2*i+1);
					i = 2*i+1;
				}
			}else{
				if(smallerThan(2*i+2, i)){
					swap(i, 2*i+2);
					i = 2*i+2;
				}
			}
		}
	}

	private boolean smallerThan(int position1, int position2){
		//check whether the distance of vertex1 is smaller than that of vertex2
		if (vHeap.get(position1).distance < vHeap.get(position2).distance){
			return true;
		}
		return false;
	}

	private void swap(int a, int b){
		if (a==b){return;}

		if (b<a){
			UndirectedVertex v1 = vHeap.remove(a);
			UndirectedVertex v2 = vHeap.remove(b);
			vHeap.add(b, v1);
			vHeap.add(a, v2);
		}else{
			UndirectedVertex v2 = vHeap.remove(b);
			UndirectedVertex v1 = vHeap.remove(a);
			vHeap.add(a, v2);
			vHeap.add(b, v1);
		}
	}

	@Override
	public String toString() {
		return vHeap.toString();
	}
}
