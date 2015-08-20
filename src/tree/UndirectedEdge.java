package tree;

import java.util.NoSuchElementException;

public class UndirectedEdge {
	UndirectedVertex v1, v2;
	int length;
	
	public UndirectedEdge(UndirectedVertex s, UndirectedVertex e, int l){
		v1 = s;
		v2 = e;
		length = l;
	}
	
	public int getEndVertexData(int data){
		if (v1.data==data){
			return v2.data;
		}else if (v2.data==data){
			return v1.data;
		}else{
			throw new NoSuchElementException();
		}
	}
	
	@Override
	public String toString() {
		return v1.data + "~" + v2.data + "^" + length;
	}
	
	@Override
	public boolean equals(Object obj) {
		UndirectedEdge e = (UndirectedEdge) obj;
		if (this.v1.data == e.v1.data && this.v2.data == e.v2.data){
			return true;
		} else if(this.v1.data == e.v2.data && this.v2.data == e.v1.data){
			return true;
		}else{
			return false;
		}
		
	}
}
