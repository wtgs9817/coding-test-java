import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int len = citations.length;
        
        
        for(int i=0; i<len; i++) {
            int count = len - i;
            
            if(citations[i] >= count ) {
                answer = Math.max(count, answer);
            }
        }
        
        return answer;
        
        
        
        
        
        
        
    }
}