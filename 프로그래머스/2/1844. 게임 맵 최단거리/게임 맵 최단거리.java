import java.util.*;
//첫번째 풀이
class Solution {
    
    
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    
    
    
    public static int bfs(int[][] maps) {
        int[] dx = {-1,1,0,0};  //y축 상하좌우
        int[] dy = {0,0,-1,1}; 
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> que = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        que.offer(new int[]{0,0});
        visited[0][0] = 1;
        
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                
                if(maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    que.offer(new int[]{nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }
        
        return visited[n-1][m-1] == 0 ? -1 : visited[n-1][m-1];

    }
}