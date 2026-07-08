// 

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int plen = progresses.length;
        int idx = 0;
        
        List<Integer> list = new ArrayList<>();
        Deque<Integer> que = new ArrayDeque<>();
        
        while(idx < plen) {
            
            for(int i=0; i<plen; i++) progresses[i] += speeds[i];
            while(idx < plen && progresses[idx] >= 100) que.offer(progresses[idx++]);
            
            if(!que.isEmpty()) {
                list.add(que.size());
                que.clear();
            }
        }
        
        int[] result = new int[list.size()];
        idx = 0;
        for(int n : list) result[idx++] = n;    
        
        return result;
    }
}