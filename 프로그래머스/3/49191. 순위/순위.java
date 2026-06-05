import java.util.*;
//두번째 풀이
class Solution {
    public int solution(int n, int[][] results) {
        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] win = new int[n+1];
        int[] lose = new int[n+1];
        
        for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
        for(int i=0; i<results.length; i++) list[results[i][0]].add(results[i][1]);
        
        for(int i=1; i<=n; i++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            
            q.offer(i);
            visited[i] = true;
            
            while(!q.isEmpty()) {
                int num = q.poll();
                
                for(int node : list[num]) {
                    if(!visited[node]) {
                        win[i]++;
                        lose[node]++;
                        visited[node] = true;
                        q.offer(node);
                    }
                }
            }
        }
        int result = 0;
        for(int i=1; i<=n; i++) {
            if((win[i] + lose[i]) == n-1) result++;     
        }
        
        return result;
    }
}