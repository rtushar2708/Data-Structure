class Solution {
    public void nextPermutation(int[] nums) {
        int min = Integer.MAX_VALUE;
        int min_idx = nums.length-1;
        int idx = -1;
        int greater = nums.length-1;

        for(int i = nums.length - 1; i >= 1; i--) {
            if(nums[i] > nums[i-1]) {
                idx = i-1;
                greater = i;
                break;
            }
        }
        if(idx == -1) {
            reverse(nums, 0, nums.length-1);
        } else {
            for(int i = nums.length-1; i >= greater; i--) {
                if(nums[i] > nums[idx] && min > nums[i]) {
                    min = nums[i];
                    min_idx = i;
                }
            }
            nums[min_idx] = nums[idx];
            nums[idx] = min;
            reverse(nums, idx+1, nums.length-1);
        }
    }
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return;
    }
}