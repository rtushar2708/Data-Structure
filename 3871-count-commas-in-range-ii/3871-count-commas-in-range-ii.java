class Solution {
    public long countCommas(long n) {
        long lower = 1000;
        int comma = 1;
        long totalCommas = 0;

        while(lower <= n) {
            long upper = lower * 1000 -1;
            if(upper > n) upper = n;
            totalCommas += (upper-lower+1)*comma;
            lower *= 1000;
            comma++;
        }

        return totalCommas;
    }
}