//세번째 풀이
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
    
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        
        
        int totalch = stages.length;
        for(int i=1; i<=N; i++) {
            int ch = 0;    
            for(int k=0; k<stages.length; k++) {
                if(stages[k] == i) {
                    ch++;
                }
                
            }
            
            if(totalch != 0) {
                map.put(i, (double) ch /totalch );
                totalch -= ch;    
            }
            
            else {
                map.put(i, 0.0);    
            }
        }
        
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        
        //정렬 여전히 바로바로 생각이 안남 좀 연습이 필요함
        list.sort((a1, a2) -> {
           int result = Double.compare(map.get(a2), map.get(a1));
            
            if(result == 0) {
                return Integer.compare(a1,a2);
            }
            
            else {
                return result;
            }
        });
        
        int[] arr = new int[list.size()];
        int cnt = 0;
        for(int a : list) {
            arr[cnt] = a;
            cnt++;
        }
        
        return arr;
    }   
        
}