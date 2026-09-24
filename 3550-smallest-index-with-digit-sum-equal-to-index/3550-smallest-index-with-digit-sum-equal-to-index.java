class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(sum(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    private int sum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}