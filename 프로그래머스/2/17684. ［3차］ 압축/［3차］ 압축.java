//알고리즘이랑 방법은 알겠는데
//뭔가 중간중간 조온나 헷갈림. 
//다시 풀어봐야 할듯.

import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        int idx = 1;
        for(char a ='A'; a<='Z'; a++) {
            map.put(String.valueOf(a), idx);
            idx++;
        }
        
        int idx2 = 0;
        while(idx2 < msg.length()) {
            int j = idx2 + 1;
            
            while(j<=msg.length() && map.containsKey(msg.substring(idx2, j))) {
                j++;
            }
            list.add(map.get(msg.substring(idx2, j-1)));
            
            if(j <= msg.length()) {
                map.put(msg.substring(idx2, j) , idx++);
            }
            
            idx2 = j-1;
        }
        
        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list) {
            answer[cnt] = num;
            cnt++;
        }
        
      
        return answer;
    }
}