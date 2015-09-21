package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i=0;i<nums.length;i++){
			Integer floor = set.floor(nums[i]+t);
			Integer ceiling = set.ceiling(nums[i]-t);
			if ((floor!=null && nums[i]<=floor) 
					|| (ceiling!=null && nums[i]>=ceiling)){
				return true;
			}

			set.add(nums[i]);
			if (i>=k){
				set.remove(nums[i-k]);
			}

		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (nums.length < 2 || k == 0) {
			return false;
		}
		TreeSet<Long> set = new TreeSet<>();

		int i = 0;
		while (i < nums.length) {
			Long floor = set.floor((long) nums[i]);
			Long ceiling = set.ceiling((long) nums[i]);
			if ((floor != null && nums[i] - floor <= t ) ||
					(ceiling != null && ceiling - nums[i] <= t)) {
				return true;
			}
			set.add((long) nums[i++]);
			if (i > k) {
				set.remove((long) nums[i - k - 1]);
			}
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}

}
