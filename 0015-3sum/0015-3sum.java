class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int k = 0;
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for(int i = 1; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(set.contains(k - (nums[i]+nums[j]))) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(k - (nums[i]+nums[j]));
                    Collections.sort(ls);
                    ans.add(ls);
                }
            }
            set.add(nums[i]);
        }

        return new ArrayList<>(ans);
    }
}