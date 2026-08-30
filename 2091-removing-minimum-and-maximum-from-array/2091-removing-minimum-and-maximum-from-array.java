class Solution {
    public int minimumDeletions(int[] nums) {
        // if(nums.length == 1) {
        //     return 1;
        // }
        // if(nums.length == 2) {
        //     return 2;
        // }
        // if(nums.length == 0) {
        //     return 0;
        // }
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int minIdx = 0;
        int maxIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < minimum) {
                minimum = nums[i];
                minIdx = i;
            }
            if(nums[i] > maximum) {
                maximum = nums[i];
                maxIdx = i;
            }
        }

        // if(minIdx == maxIdx) {
        //     return Math.min(nums.length - minIdx, minIdx + 1);
        // }

        int lowerIdx = Math.min(minIdx, maxIdx);
        int higherIdx = Math.max(minIdx, maxIdx);

        int case1 = (lowerIdx + 1) + (nums.length - higherIdx);
        int case2 = higherIdx+1;
        int case3 = nums.length - lowerIdx;

        return Math.min(case1, Math.min(case2, case3));
    }
}