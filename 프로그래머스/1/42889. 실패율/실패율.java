//네번째 풀이
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int totalch = stages.length;
        Map<Integer, Double> map = new HashMap<>();
        
        for(int i=1; i<=N; i++) {
            int ch = 0;
            for(int k=0; k<stages.length; k++) {
                if(i == stages[k]) {
                    ch++;
                }   
            }
            
            if(ch == 0) {
                    map.put(i , 0.0);
                }
                else {
                    map.put(i, (double) ch / totalch);
                    totalch -= ch;    
                }             
        }
        
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        
        list.sort((a1, a2) -> {
           int result = Double.compare(map.get(a2), map.get(a1));
            
            if(result == 0 ) {
                return Integer.compare(a1, a2);
            }
            
            else {
                return result;
            }
            
        });
        
        int[] answer = new int[list.size()];
        int count = 0;
        
        for(int num : list) {
            answer[count] = num;
            count++; 
        }
      
        return answer;
                
    }   
        
}