import java.util.*;

class Solution {
    static Queue<int[]> que;
    static int[] answer;
    
    public int[] solution(String[][] places) {
        answer = new int[5];
        
        for(int i=0; i<5; i++) {
            que = new ArrayDeque<>();
            for(int k=0; k<5; k++) {
                for(int j=0; j<5; j++) {
                    if(places[i][k].charAt(j) == 'P') {
                        que.offer(new int[]{i,k,j});
                    }
                }
            }
            bfs(que, places);
        }
        
        for(int i=0; i<5; i++) {
            if(answer[i] == -1) {
                answer[i] = 0;
            }
            else {
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    
    public static void bfs(Queue<int[]> que, String[][] places) {
        //거리 1  상 하 좌 우
        int[] x1 = {0,0,-1,1};
        int[] y1 ={-1,1,0,0};
        
        //거리 2 
        int[] x2 = {0,0,-2,2};
        int[] y2 = {-2,2,0,0};
        
        //대각선  왼쪽 상단부터 시계방향
        int[] x3 = {-1,1,1,-1};
        int[] y3 = {-1,-1,1,1};
        
        boolean flag =true;
        
        while(!que.isEmpty() && flag) {
            int[] arr = que.poll();
            int x = arr[2];
            int y = arr[1];
            int z = arr[0];
            
            
            
            
            for(int i=0; i<4; i++) {
                //거리1
                int nx1 = x + x1[i];
                int ny1 = y + y1[i];
                
                //거리2
                int nx2 = x + x2[i];
                int ny2 = y + y2[i];
                
                //대각선
                int nx3 = x + x3[i];
                int ny3 = y + y3[i];
                
                
                
                
                //거리 1 P
                if(nx1 >= 0 && nx1 < 5 && ny1 >= 0 && ny1 < 5) {
                    if(places[z][ny1].charAt(nx1) == 'P') {
                    answer[z] = -1;
                    flag = false;
                    break;
                    }    
                }
                
                
                //거리 2 P
                if(nx2 >= 0 && nx2 < 5 && ny2 >= 0 && ny2 <5) {
                    if(places[z][ny2].charAt(nx2) == 'P') {
                    int midX = (x + nx2) /2;
                    int midY = (y + ny2) /2;
                    
                        if(!(places[z][midY].charAt(midX)=='X')) {
                            answer[z] = -1;
                            flag = false;
                            break;
                        } 
                    }
                }    
                
                
                //대각선 P
                if(nx3 >= 0 && nx3 < 5 && ny3 >= 0 && ny3 <5) {
                    if(places[z][ny3].charAt(nx3) == 'P') {
                        if(!(places[z][ny3].charAt(x) == 'X' && places[z][y].charAt(nx3) == 'X')) {
                            answer[z] = -1;
                            flag = false;
                            break;
                        }   
                    } 
                }
                    
            }
            
        }
    }
}