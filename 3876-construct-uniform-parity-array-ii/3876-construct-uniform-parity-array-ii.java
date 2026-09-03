class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean evenArray = true;
        for(int i = 0; i < nums1.length; i++) {
            if(nums1[i] % 2 == 1) {
                evenArray = false;
            }
            min = Math.min(min, nums1[i]);
        }

        if(!evenArray && min % 2 == 0) {
            return false;
        }
        return true;
    }
}