// 다시 풀어보기
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        
        //도달 + 해결한 사람
        int totalCh = stages.length;
        
        int[] arr = new int[N];
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        for(int i=1; i<=N; i++) {
            //도달한 사람
            int ch = 0;
            
            for(int k=0; k<stages.length; k++) {
                if(stages[k] == i) {
                    ch++;
                }
            
            }
            if(ch == 0 || totalCh == 0) {
                map.put(i, 0.0);
            }
            
            else {
                map.put(i, (double) ch / totalCh);
                totalCh -= ch;
            }
           
        } 
            List<Integer> list = new ArrayList<Integer>(map.keySet());
            //정렬 부분, 람다식 다시 공부
            list.sort((a1,a2) -> {
                int result = Double.compare(map.get(a2),map.get(a1));
                
                if(result == 0 ) {
                    return Integer.compare(a1,a2);    
                }
                
                else {
                    return result;
                }
                
            });
            
            int idx = 0;
            for(int a : list) {
                arr[idx] = a;
                idx++;
            }
            
            return arr;

        
    }      
        
}