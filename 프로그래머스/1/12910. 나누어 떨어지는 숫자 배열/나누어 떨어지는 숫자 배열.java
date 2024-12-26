import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
    
        int[] answer;
        
        answer = Arrays.stream(arr).filter(x -> x%divisor == 0).toArray();
        
        if(answer.length == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        
        else {
            Arrays.sort(answer);
        }
        
        return answer;
    }
}