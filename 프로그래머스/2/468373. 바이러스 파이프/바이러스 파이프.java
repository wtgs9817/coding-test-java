//복습
/*
1~n  n개의 배양체 n-1 파이프
A, B, C 파이프 3개
배양체 중 하나 감염 -> 열린 파이프를 통해 감염
최대 k번 반복 파이프 하나씩 염
*/
import java.util.*;
class Solution {
    char[] ch = {'A', 'B', 'C'};
    int virus;
    int result =0;
    ArrayList<int[]>[] list;
    public int solution(int n, int infection, int[][] edges, int k) {
        list = new ArrayList[n+1];
        int len = edges.length;
        virus = infection;
        for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
        for(int i=0; i<len; i++) {
            int[] arr = edges[i];
            
            list[arr[0]].add(new int[]{arr[1], arr[2]});
            list[arr[1]].add(new int[]{arr[0], arr[2]});
        }
        dfs("",0, k, n);
        return result;
    }
    
    void dfs(String str, int depth, int k, int n) {
        if(result == n) return;
        if(depth == k) {
            boolean[] visited = new boolean[n+1];
            visited[virus] = true;
            int cnt = 1;
            for(int i=0; i<k; i++) {
                ArrayDeque<Integer> que = new ArrayDeque<>();
                for(int y=1; y<=n; y++) if(visited[y]) que.offer(y);
            
                int pipe = 0;
                char a = str.charAt(i);
                if(a == 'A') pipe = 1;
                else if(a == 'B') pipe = 2;
                else pipe = 3;
                
                while(!que.isEmpty()) {
                    int num = que.poll();
                    
                    for(int[] node : list[num]) {
                        int n1 = node[0];
                        int n2 = node[1];
                        
                        if(pipe == n2 && !visited[n1]) {
                            visited[n1] = true;
                            que.offer(n1);
                            cnt++;
                        }
                    }
                } 
            }
            result = Math.max(result, cnt);
            return;
        }
        for(int i=0; i<3; i++) dfs(str+ch[i], depth+1, k, n); 
    }
}