package leetcode;
import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] results = new int[2];
		
		HashMap<Integer, Integer> h = new HashMap<>();
		for (int i=0;i<nums.length;i++){
			if (h.containsKey(target-nums[i])){
				int j = h.get(target-nums[i]);
				results[0] = Math.min(i, j)+1;
				results[1] = Math.max(i, j)+1;
				return results;
			}
			h.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = new TwoSum().twoSum(new int[]{3,2,4,9}, 6);
		System.out.println(a[0]+", "+a[1]);

	}

}
