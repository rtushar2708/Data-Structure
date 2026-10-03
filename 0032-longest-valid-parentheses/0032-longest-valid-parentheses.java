class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if(open == close) {
                int currMax = open+close;
                max = Math.max(max, currMax);
            }
            if(close > open) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;
        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                open++;
            }else {
                close++;
            }
            if(open == close) {
                int currMax = open+close;
                max = Math.max(max, currMax);
            }
            if(open > close) {
                open = 0;
                close = 0;
            }
        }

        return max;
    }
}