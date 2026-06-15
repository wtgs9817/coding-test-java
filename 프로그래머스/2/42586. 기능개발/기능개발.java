import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        int len = speeds.length;
        boolean[] visited = new boolean[len];
        
        int idx = 0;
        int count = 0;
        
        while(true) {
            if(len == idx) break;
            
            while(!que.isEmpty()) {
                int num = que.poll();
                count++;
    
                if(que.isEmpty()) {
                    list.add(count);
                    count = 0;
                }
            }
            
            for(int i=0; i<len; i++) {
                progresses[i] += speeds[i];
                
                if(!visited[i] && progresses[idx] >= 100) {
                    que.offer(idx);
                    visited[idx] = true;
                    idx++;
                }
            }  
        }
        
        list.add(que.size());
        
        int[] result = new int[list.size()];
        idx = 0;
        for(int n : list) result[idx++] = n;
        return result;
    }
}