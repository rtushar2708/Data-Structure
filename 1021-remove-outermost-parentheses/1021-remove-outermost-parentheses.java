class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(char ch: s.toCharArray()) {
            if(count == 0 && ch == '(') {
                count++;
            } else if(count == 1 && ch == ')') {
                count--;
            } else {
                if(ch == '(') {
                    count++;
                } else {
                    count--;
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}