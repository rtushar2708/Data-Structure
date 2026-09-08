class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int count = 0;
        set.put(0, 1);
        set.put(nums[0], set.getOrDefault(nums[0], 0)+1);
        if(k == nums[0]) count++;
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
            if(set.containsKey(nums[i]-k)) {
                count += set.get(nums[i]-k);
            }
            set.put(nums[i], set.getOrDefault(nums[i], 0)+1);
        }

        return count;
    }
}