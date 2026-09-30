class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0;
        int[] ans = new int[seq.length()];
        for(int i = 0; i < seq.length()-1; i++) {
            if(seq.charAt(i) == '(') {
                depth++;
                ans[i] = (depth%2 == 1) ? 0 : 1;
            } else {
                ans[i] = (depth%2 == 1) ? 0 : 1;
                depth--;
            }
        }

        return ans;
    }
}