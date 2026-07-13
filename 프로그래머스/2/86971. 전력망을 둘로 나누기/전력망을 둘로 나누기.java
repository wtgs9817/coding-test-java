import java.util.*;
//다시 풀어보기

class Solution {
    static List<Integer>[] list;
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        int result = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
        for(int i=0; i<wires.length; i++) {
            int[] arr = wires[i];
            int a = arr[0];
            int b = arr[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int i=0; i<wires.length; i++) {
            int[] arr = wires[i];
            
            int count = bfs(n, wires, arr, i);
            result = Math.min(count, result);
        }
        
        return result;     
    }
    
    static int bfs(int n, int[][] wires, int[] arr, int node) {
        int count = 1;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int a = arr[0];
        int b = arr[1];
        
        q.offer(b);
        visited[b] = true;
        
        while(!q.isEmpty()) {
            int aa = q.poll();
            
            for(int aaa : list[aa]) {
                if(aaa != a && !visited[aaa]) {
                    q.offer(aaa);
                    visited[aaa] = true;
                    count++;
                } 
            }
        }
        
        return Math.abs((n - count) - count);
    }
}