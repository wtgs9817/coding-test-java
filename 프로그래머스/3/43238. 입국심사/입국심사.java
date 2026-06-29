import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        
        
        while(left <= right) {
            long pe = 0;
            long mid = (left + right) / 2;
            
            for(int time : times) {
                pe += mid / time;
                if(pe >= n) break;
            }
            
            if(pe >= n) {
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return answer;
    }
}