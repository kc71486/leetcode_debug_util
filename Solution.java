import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int count = 0;
        int high = 0x80000000;
        for(int i = 0; i < pairs.length; i ++) {
            if(pairs[i][0] > high) {
                count ++;
                high = pairs[i][1];
            }
        }
        return count;
    }
}