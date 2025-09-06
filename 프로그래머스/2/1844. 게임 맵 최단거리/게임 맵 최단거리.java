import java.util.*;
//첫번째 풀이
//두번째 풀이  한번은 더 풀어보자
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int y = maps.length;
        int x = maps[0].length;
        
        Queue<int[]> que = new ArrayDeque<>();
        int[][] visited = new int[y][x];
        
        
        
        int[] nx = {0,0,-1,1}; //상하좌우
        int[] ny = {-1,1,0,0};
        
        que.offer(new int[]{0,0});
        visited[0][0] = 1;
        
        
        
        while(!que.isEmpty()) {
            int[] loc = que.poll();
            
            int lx = loc[1];
            int ly = loc[0];
            
            if(lx == x-1 && ly == y-1 ) {
                answer = visited[ly][lx];
            }
            
            for(int i=0; i<4; i++) {
                int xx = lx+nx[i];
                int yy = ly+ny[i];
                
                if(xx < 0 || xx >= x || yy < 0 || yy >= y) {
                    continue;
                }
                
                if(maps[yy][xx] == 1 && visited[yy][xx] == 0) {
                    que.offer(new int[]{yy,xx});
                    visited[yy][xx] = visited[ly][lx] + 1;
                }                
            }  
        }
        
        if(answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
    
    
    
    
    
    
    
    
    /*
    
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
    
    */
}