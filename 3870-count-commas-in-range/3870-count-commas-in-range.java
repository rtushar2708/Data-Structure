class Solution {
    public int countCommas(int n) {
        if(n <= 999) {
            return 0;
        }
        System.gc();
        return n-999;
    }
}