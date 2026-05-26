//복습
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] list = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] nn : wires) {
            int a = nn[0];
            int b = nn[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        int result = Integer.MAX_VALUE;
        
        ArrayDeque<Integer> que = new ArrayDeque<>(); 
        for(int[] nn : wires) {
            int a = nn[0];
            int b = nn[1];
            int cnt = 1;
            que.offer(a);
            boolean[] visited = new boolean[n+1];
            visited[a] = true;
            
            while(!que.isEmpty()) {
                int n1 = que.poll();    
                
                if(n1 == b) continue;
                
                for(int num : list[n1]) {
                    if(num != b && !visited[num]) {
                        cnt++;
                        visited[num] = true;
                        que.offer(num);
                    }
                } 
            }
            
            result = Math.min(result, (Math.abs((n-cnt) - cnt)));
        }
        
        return result;
    }
}