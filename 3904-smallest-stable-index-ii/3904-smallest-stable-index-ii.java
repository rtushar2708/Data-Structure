class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // create suffixMin array
        int[] suffixMin = new int[nums.length];
        suffixMin[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
        }

        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(max - suffixMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}