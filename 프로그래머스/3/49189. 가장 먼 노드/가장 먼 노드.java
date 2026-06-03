import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] dist = new int[n+1];
        int max = 0;
        for(int i=1; i<=n; i++) {
            list[i] =  new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 1;
        
        for(int i=0; i<edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        
        while(!q.isEmpty()) {
            int n1 = q.poll();
            
            for(int node : list[n1]) {
                if(dist[node] > dist[n1] + 1) {
                    dist[node] = dist[n1] + 1;
                    q.offer(node);
                    
                    if(dist[node] > max ) max = dist[node];
                    
                }
            }
        }
        
        int answer = 0;
        for(int n2 : dist) {
            if(max == n2) answer++; 
        }
        
        return answer; 
    }
}