
import java.util.*;

class Solution {
    int result = 0;
    ArrayList<int[]>[] list;
    char[] str = {'A','B','C'};
    public int solution(int n, int infection, int[][] edges, int k) {
        list = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
        for(int i=0; i<edges.length; i++) {
            int[] arr = edges[i];
            
            list[arr[0]].add(new int[]{arr[1], arr[2]});
            list[arr[1]].add(new int[]{arr[0], arr[2]});
        }
        
        dfs("", 0, k, n, infection);
        return result;
    }
    void dfs(String a, int depth, int m, int n, int in) {
        if(result == n) return;
        if(depth == m) {
            boolean[] visited = new boolean[n+1];
            visited[in] = true;
            int cnt = 1;
            
            for(int i=0; i<m; i++) {
                ArrayDeque<Integer> q = new ArrayDeque<>();
                for(int k=1; k<=n; k++) if(visited[k]) q.offer(k);
                    
                char c = a.charAt(i);
                int pipe = (c == 'A') ? 1 : (c == 'B') ? 2 : 3;
         
                while(!q.isEmpty()) {
                    int n1 = q.poll();
                    
                    for(int[] n2 : list[n1]) {
                        if(n2[1] == pipe && !visited[n2[0]]) {
                            visited[n2[0]] = true;
                            cnt++;
                            q.offer(n2[0]);
                        }
                    } 
                }    
                result = Math.max(result, cnt);
            }
            return;
        }
        for(int i=0; i<3; i++) dfs(a + str[i], depth+1, m, n, in);
    }
    
    
}