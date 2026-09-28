class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currDepth = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                currDepth++;
                maxDepth = Math.max(maxDepth, currDepth);
            } else if(ch == ')') {
                currDepth--;
            }else {
                continue;
            }
        }

        return maxDepth;
    }
}