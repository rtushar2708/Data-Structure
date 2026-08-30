class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        // int bucket = 0;
        int i = 0;
        int j = 0;
        while(j < n) {
            if(nums[j] == 0) {
                // bucket++;
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        while(i < n) {
            nums[i] = 0;
            i++;
        }
    }
}