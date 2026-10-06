class Solution {
    public int minAddToMakeValid(String s) {
        int depth = 0;
        int ans = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                depth++;
            }else {
                depth--;
            }
            if(depth == -1) {
                ans++;
                depth = 0;
            }
        }
        ans += depth;

        return ans;
    }
}