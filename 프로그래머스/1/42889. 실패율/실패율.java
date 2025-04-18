//두번째 풀이
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        
        //스테이지 도달 + 해결한 사람
        int totalch = stages.length;
        
        for(int i=1; i<=N; i++) {
            //해당 스테이지 도달한 사람
            int ch = 0;
            for(int k=0; k<stages.length; k++) {
                if(stages[k] == i) {
                    ch++;
                }
            }
            
            if(ch == 0 || totalch == 0) {
                map.put(i, 0.0);
            }
            
            else {
                map.put(i, (double) ch/totalch);
                totalch -= ch;
            }
        }
        
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        
         //정렬, 람다식 공부 두번째 풀이 때도 좀 헷갈림 바로바로 안나옴
        list.sort((a1,a2) -> {
            int result = Double.compare(map.get(a2), map.get(a1));
            
            if(result == 0) {
                return Integer.compare(a1, a2);
            }
            
            else {
                return result;
            }
            
        });
        
        int[] arr = new int[list.size()];
        int idx = 0;
        for(int a : list) {
            arr[idx] = a;
            idx++;
        }
        
        return arr;

    }      
        
}