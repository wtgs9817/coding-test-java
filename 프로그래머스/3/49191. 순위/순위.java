import java.util.*;

class Solution {
    int[] win;
    int[] lose;
    ArrayList<Integer>[] list;
    public int solution(int n, int[][] results) {
        int result = 0;
        
        list = new ArrayList[n+1];
        win = new int[n+1];
        lose = new int[n+1];
        
        for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
        for(int i=0; i<results.length; i++) {
            int[] arr = results[i];
            int a = arr[0];
            int b = arr[1]; // a > b
            
            list[a].add(b);
        }
        
        for(int i=1; i<=n; i++) {
            bfs(i, n);
        }
        
        for(int i=1; i<=n; i++) {
            if((win[i] + lose[i]) == n-1) result++;
        }
        
        return result;
    }
    
    void bfs(int w, int n) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.offer(w);
        int count = 0;
        while(!q.isEmpty()) {
            int num = q.poll();
            visited[num] = true;
            
            for(int node : list[num]) {
                if(!visited[node]) {
                    win[w]++;
                    lose[node]++;
                    visited[node] = true;
                    q.offer(node);
                }
            } 
        }
    }
}