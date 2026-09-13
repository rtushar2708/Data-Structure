class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlaps = 0;

        for(int rowOfSet = 1-n; rowOfSet < n; rowOfSet++) {
            for(int colOfSet = 1-n; colOfSet < n; colOfSet++) {
                int overlaps = countOverlaps(img1, img2, rowOfSet, colOfSet);
                maxOverlaps = Math.max(maxOverlaps, overlaps);
            }
        }

        return maxOverlaps;
    }

    private int countOverlaps(int[][] img1, int[][] img2, int rowOfSet, int colOfSet) {
        int n = img1.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i - rowOfSet < 0 || 
                j - colOfSet < 0 || 
                i - rowOfSet >= n || 
                j - colOfSet >= n) {
                continue;
            }
                if(img2[i][j] == 1 && img1[i-rowOfSet][j-colOfSet] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}