class Solution {
    public String reverseParentheses(String s) {
        StringBuilder curr = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                stack.push(curr);
                curr = new StringBuilder();
            }else if(ch == ')') {
                StringBuilder prev = stack.pop();
                curr.reverse();
                prev.append(curr);
                curr = prev;
            }else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}