package leetcode;

import java.util.*;

public class ConsistentHashing {
	
	public static void main(String[] args) {
		System.out.println(consistentHashing(6));

	}

	public static List<List<Integer>> consistentHashing(int n) {
		Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> total = new ArrayList<>();
        total.add(0);
        total.add(359);
        total.add(1);
        queue.offer(total);

        for (int i = 2; i <= n; i++){
            List<Integer> interval = queue.poll();
            int start = interval.get(0);
            int end = interval.get(1);
            int index = interval.get(2);
            int mid = (end + start) / 2;
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(start);
            temp1.add(mid);
            temp1.add(index);
            queue.offer(temp1);
            
            List<Integer> temp2 = new ArrayList<>();
            temp2.add(mid+1);
            temp2.add(end);
            temp2.add(i);
            queue.offer(temp2);
            System.out.println(queue);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }
        Collections.sort(res, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> l1, List<Integer> l2){
                return l1.get(0) - l2.get(0);
            }
        });

        return res;
    }
	
	
	//===============================================================
	
	static int n;
    static int k;
    //map - hashcode to id
    static Map<Integer, Integer> map;
    ConsistentHashing hashing;

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static ConsistentHashing create(int n, int k) {
        // Write your code here
        return new ConsistentHashing(n, k);
    }
    
    private ConsistentHashing(int n, int k){
        this.n = n;
        this.k = k;
        map = new HashMap<>();
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        Random rand = new Random();
        List<Integer> res = new ArrayList<>();
        int index = rand.nextInt(n);
        for (int i = 0; i < k; i++){
            while (map.containsKey(index)){
                index = rand.nextInt(n);
            }
            map.put(index, machine_id);
            res.add(index);
        }
        Collections.sort(res);
        return res;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {

        int index = Integer.MAX_VALUE;
        int id = -1;
        for (Integer i : map.keySet()){
            if (i > hashcode && i < index){
                index = i;
                id = map.get(i);
            }
        }
        return id;
    }
}
