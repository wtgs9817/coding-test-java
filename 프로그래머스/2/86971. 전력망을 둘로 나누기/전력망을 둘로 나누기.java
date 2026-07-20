//복습
/*
n은 2 이상 100 이하인 자연수
wires는 길이가 n-1인 정수형 2차원 배열 --> 트리
wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미
*/

import java.util.*;
class Solution {
    static List<Integer>[] list;
    static int result;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        result = Integer.MAX_VALUE;
        int len = wires.length;
        
        for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
        for(int[] arr : wires) {
            int a = arr[0];
            int b = arr[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int[] arr : wires) {
            Deque<Integer> que = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            int a = arr[0];
            int b = arr[1];
            
            que.offer(b);
            visited[b] = true;
            int cnt = 1;
            
            while(!que.isEmpty()) {
                int num = que.poll();
                
                for(int n1 : list[num]) {
                    if(n1 != a && !visited[n1]) {
                        visited[n1] = true;
                        que.offer(n1);
                        cnt++;
                    }
                }
            }
            
            int w = Math.abs((n - cnt) - cnt);
            result = Math.min(result, w);
        }
        
        return result;      
    }      
}