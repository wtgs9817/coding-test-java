import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        int cnt = 0;
        for(int i=0; i<d.length; i++) {
            if(answer+d[i] <= budget) {
                answer+=d[i];
                cnt++;
            }
            
            if(answer > budget) {
                break;
            }
        }
        
        return cnt;
    }
    
}    