/*
1 ≤ n ≤ 10^7
0 ≤ left ≤ right < n2
right - left < 10^5
*/
import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left) + 1;
        int[] answer = new int[len];
        
        for(long i=left; i<=right; i++) {
            int ansIdx = (int) (i - left);
            
            int row = (int) (i/n);
            int col = (int) (i%n);
            
            answer[ansIdx] = Math.max(row,col) + 1;
        }
        return answer;
    }
}