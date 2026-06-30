import java.util.*;
//복습
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length-1] * n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long p = 0;
            
            for(int time : times) {
                p +=  (long) mid / time;
                if(p >= n) break;
            }
            
            if(p >= n) {
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        
        return answer;
    }
}