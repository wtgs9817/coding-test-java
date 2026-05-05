import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        //상 하 좌 우
        int[] X = {0,0,-1,1};
        int[] Y = {-1,1,0,0};
        ArrayDeque<int[]> que = new ArrayDeque<>();
        int a = maps.length;
        int b = maps[0].length;
        
        int[][] result = new int[a][b];
        
        result[0][0] = 1;
        que.offer(new int[]{0,0});
        
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            
            int x = arr[1];
            int y = arr[0];
            
            for(int i=0; i<4; i++) {
                int dx = X[i] + x;
                int dy = Y[i] + y;
                
                if(dx < 0 || dx >= b || dy < 0 || dy >= a) continue;
                
                if(maps[dy][dx] == 1 && result[dy][dx] == 0) {
                    que.offer(new int[]{dy,dx});
                    result[dy][dx] = result[y][x] + 1;
                    
                    if(dy == (a-1) && dx == (b-1)) return result[dy][dx];
                }
            }
        }
        return result[a-1][b-1] == 0 ? -1 : result[a-1][b-1];
    }
}